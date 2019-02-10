import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static final int SIZE = 10_000_000;
    static final int HALF_SIZE = SIZE / 2;

    public static void main(String[] args) {
        firstMethod();

        try {
            secondMethod();
        } catch (InterruptedException e) {
            System.out.println("got interrupted!");
        }
    }

    public static float calcFloat(float num, int index) {
       return (float)(num * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
    }

    public static void calculate(float[] arr) {
        for (int i = 0;i < arr.length; i++) {
            arr[i] = calcFloat(arr[i], i);
        }
    }

    public static void firstMethod() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void secondMethod() throws InterruptedException{
        int THREAD_COUNT = 12;
        int PART_SIZE = SIZE / THREAD_COUNT;
        float[] arr = new float[SIZE];
        float[][] parts = new float[THREAD_COUNT][PART_SIZE];

        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        for(int i=0; i < THREAD_COUNT; i++) {
            System.arraycopy(arr, PART_SIZE * i, parts[i], 0, PART_SIZE);
        }

        Thread[] threads = new Thread[THREAD_COUNT];
        for(int i=0; i < THREAD_COUNT; i++) {
            float[] currentPart = parts[i];
            threads[i] = new Thread(() -> {
                calculate(currentPart);
            });

            threads[i].start();
        }

        for(int i=0; i < THREAD_COUNT; i++) {
            threads[i].join();
        }

        System.out.println(System.currentTimeMillis() - a);
    }
}
