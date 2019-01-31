import exceptions.MySizeArrayException;
import exceptions.MyArrayDataException;

public class Matrix {
    private String[][] matrix;
    private int xSize;
    private int ySize;

    public Matrix(String[][] matrix, int xSize, int ySize) {
        Boolean isValid = !Matrix.validate(matrix, xSize, ySize);

        if (isValid) {
            throw new MySizeArrayException();
        }
        this.matrix = matrix;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    static Boolean validate(String[][] matrix, int xSize, int ySize) {
        if (matrix.length != ySize) {
            return false;
        }

        for (String[] row : matrix) {
            if (row.length != xSize) {
                return false;
            }
        }

        return true;
    }

    public int calculate() {
        int result = 0;

        for (int iy = 0; iy < matrix.length; iy++ ) {
            for (int ix = 0; ix < matrix.length; ix++) {
                String currentVal = matrix[iy][ix];
                try {
                    result = result + Integer.parseInt(currentVal);
                } catch(NumberFormatException ex) {
                    throw new MyArrayDataException(iy, ix, currentVal, ex);
                }
            }
        }

        return result;
    }
}
