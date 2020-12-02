
public class MainMatrix {

    public static final int MATRIX_SIZE = 5;

    public static void main(String[] args) {

        int[][] matrix1 = matrixGeneration(MATRIX_SIZE, MATRIX_SIZE);
        int[][] matrix2 = matrixGeneration(MATRIX_SIZE, MATRIX_SIZE);

        int[][] resultClassic = ClassicMatrix.multiplyMatrix(matrix1, matrix2);
        ClassicMatrix.displayMatrix(resultClassic);

    }

    public static int[][] matrixGeneration(int rows, int columns) {
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = (int) Math.round((Math.random() * 30) - 15); // [-15, 15]
            }
        }
        return result;
    }

}
