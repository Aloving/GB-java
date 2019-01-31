package exceptions;

public class MySizeArrayException extends RuntimeException {
    public MySizeArrayException() {
        super("Matrix size is not correct");
    }
}
