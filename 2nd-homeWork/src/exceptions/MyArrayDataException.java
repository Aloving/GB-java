package exceptions;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int x, int y, String val, NumberFormatException ex) {
        super(
            String.format("Cell [%d, %d] contains no number: \"%s\"", x , y, val),
            ex
        );
    }
}
