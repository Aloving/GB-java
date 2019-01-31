import exceptions.EmptyArgumentException;

import java.lang.reflect.Array;

public class Validator {
    private Matrix matrix;

    private Validator(String[][] matrix) {
        if (Array.getLength(matrix) == 0) {
            throw new EmptyArgumentException();
        }

    }
}
