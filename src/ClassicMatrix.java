public class ClassicMatrix {

    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        int column1 = matrix1[0].length; // matrix1 columns length
        int rows1 = matrix1.length;    // matrix1 result rows length
        int column2 = matrix2[0].length; // matrix2 result columns length
        int rows2 = matrix2.length;    // matrix2 rows length
        if (column1 != rows2) return null; // matrix multiplication is not possible
        int[][] resultMatrix = new int[rows1][column2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < column2; j++) {
                for (int k = 0; k < column1; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return resultMatrix;
    }

    public static void displayMatrix(int[][] resultMatrix) {
        System.out.println();
        int rows = resultMatrix.length;
        int columns = resultMatrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(resultMatrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
