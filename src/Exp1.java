import java.util.Scanner;

public class Exp1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for first array
        System.out.print("Enter rows and columns for array 1: ");
        int row1 = scanner.nextInt();
        int col1 = scanner.nextInt();
        int[][] array1 = new int[row1][col1];
        System.out.println("Enter values for array 1: ");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                array1[i][j] = scanner.nextInt();
            }
        }

        // Input for second array
        System.out.print("Enter rows and columns for array 2: ");
        int row2 = scanner.nextInt();
        int col2 = scanner.nextInt();
        int[][] array2 = new int[row2][col2];
        System.out.println("Enter values for array 2: ");
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                array2[i][j] = scanner.nextInt();
            }
        }

        // Addition
        System.out.println("Addition of two arrays is: ");
        if (row1 == row2 && col1 == col2) {
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    System.out.print((array1[i][j] + array2[i][j]) + " ");
                }
                System.out.println();
            }
        }

        // Subtraction
        System.out.println("Subtraction of two arrays is: ");
        if (row1 == row2 && col1 == col2) {
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    System.out.print((array1[i][j] - array2[i][j]) + " ");
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}