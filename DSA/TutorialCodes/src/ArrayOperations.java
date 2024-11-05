import java.util.Scanner;
public class ArrayOperations {
    public static void insertElements1D(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + array.length + " elements for the 1D array:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
    }
    public static void display1DArray(int[] array) {
        System.out.print("1D Array: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
    public static void display2DArray(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert elements in a 1D array");
            System.out.println("2. Transpose a 2D array (matrix)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the size of the 1D array: ");
                    int size = scanner.nextInt();
                    int[] array1D = new int[size];
                    insertElements1D(array1D);
                    display1DArray(array1D);
                    break;
                case 2:
                    System.out.print("Enter the number of rows for the 2D array: ");
                    int rows = scanner.nextInt();
                    System.out.print("Enter the number of columns for the 2D array: ");
                    int cols = scanner.nextInt();
                    int[][] matrix = new int[rows][cols];
                    System.out.println("Enter elements for the 2D array (matrix):");
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            matrix[i][j] = scanner.nextInt();
                        }
                    }
                    System.out.println("Original Matrix:");
                    display2DArray(matrix);
                    int[][] transposedMatrix = transposeMatrix(matrix);
                    System.out.println("Transposed Matrix:");
                    display2DArray(transposedMatrix);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }
}