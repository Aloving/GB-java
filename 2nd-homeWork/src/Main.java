public class Main {
    public static void main(String[] args) {
        String[][] myMatrix = new String[4][4];

        myMatrix[0][0] = "1";
        myMatrix[0][1] = "2";
        myMatrix[0][2] = "3";
        myMatrix[0][3] = "4";

        myMatrix[1][0] = "5";
        myMatrix[1][1] = "6";
        myMatrix[1][2] = "7";
        myMatrix[1][3] = "8";

        myMatrix[2][0] = "9";
        myMatrix[2][1] = "10";
        myMatrix[2][2] = "11";
        myMatrix[2][3] = "12";

        myMatrix[3][0] = "13";
        myMatrix[3][1] = "14";
        myMatrix[3][2] = "15";
        myMatrix[3][3] = "asd";

        Matrix matrix = new Matrix(myMatrix, 4, 4);

        System.out.println(matrix.calculate());
    }
}
