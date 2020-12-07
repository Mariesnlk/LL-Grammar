import java.util.Date;
import java.util.Random;

public class MainMatrix {

    public static final int MATRIX_SIZE = 2000;

    public static void main(String[] args) {
        Date start = new Date();
        int[][] matrix1 = matrixGeneration(MATRIX_SIZE, MATRIX_SIZE);
        int[][] matrix2 = matrixGeneration(MATRIX_SIZE, MATRIX_SIZE);

        int[][] resultClassic = ClassicMatrix.multiplyMatrix(matrix1, matrix2);
//        System.out.println("Matrix 1 : ");
//        ClassicMatrix.displayMatrix(matrix1);
//
//        System.out.println("\nMatrix 2 : ");
//        ClassicMatrix.displayMatrix(matrix2);
//
//        System.out.println("\nOutput Matrix : ");
//        ClassicMatrix.displayMatrix(resultClassic);

        Date end = new Date();
        System.out.println("\nTime taken in milli seconds: " + (end.getTime() - start.getTime()));

        Date start1 = new Date();

        int[][] m1 = matrixGeneration(MATRIX_SIZE, MATRIX_SIZE);
        int[][] m2 = matrixGeneration(MATRIX_SIZE, MATRIX_SIZE);

        int[][] result = new int[m1.length][m2[0].length];
        ThreadingMatrix.multiply(m1, m2, result);

        Date end1 = new Date();
        System.out.println("\nTime taken in milli seconds: " + (end1.getTime() - start1.getTime()));

        System.out.println("\nDifference between two multiply: " + ((end.getTime() - start.getTime()) / (end1.getTime() - start1.getTime())));

    }

    public static int[][] matrixGeneration(int rows, int columns) {
        int[][] result = new int[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = random.nextInt(100) * 10;
            }
        }
        return result;
    }

}
