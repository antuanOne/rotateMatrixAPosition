package com.company;

import java.util.Scanner;

public class RotateMatrixMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type numbers of columns and rows (n x n).-");
        int rows = scanner.nextInt();
        int[][] matrix = fillMatrix(rows);
        printFullMatrix(matrix);
        System.out.println("");
        System.out.println("**********************************************************************************");
        System.out.println("");
        rotatePositionNMatrix(matrix);
    }

    private static void rotatePositionNMatrix(int[][] matrix) {
        int lastIndex = matrix.length - 1;
        int firstIndex = 0;

        for (int y = 0; y < (matrix.length / 2); y++) {
            //get the corners
            /*
            [00 .... 0x]
            [ ........ ]
            [x0 .... xx]
             */
            int auxVal0x = matrix[firstIndex][lastIndex];
            int auxValxx = matrix[lastIndex][lastIndex];
            int auxValx0 = matrix[lastIndex][firstIndex];

            //Move a position left top
            for (int x = matrix.length - 1; x > firstIndex; x--) {
                matrix[firstIndex][x] = matrix[firstIndex][x - 1];
            }

            //Move a position down last column
            for (int x = matrix.length - 1; x > firstIndex; x--) {
                matrix[x][matrix.length - 1] = matrix[x - 1][matrix.length - 1];
            }

            //Move a position right last row
            for (int x = firstIndex; x < matrix.length - 1; x++) {
                matrix[matrix.length - 1][x] = matrix[matrix.length - 1][x + 1];
            }

            //Move a position up first column
            for (int x = firstIndex; x < matrix.length - 1; x++) {
                matrix[x][firstIndex] = matrix[x + 1][firstIndex];
            }

            matrix[firstIndex + 1][lastIndex] = auxVal0x;

            matrix[lastIndex][lastIndex - 1] = auxValxx;

            matrix[lastIndex - 1][firstIndex] = auxValx0;

            lastIndex = lastIndex-1;
            firstIndex = firstIndex+1;
        }

        printFullMatrix(matrix);
    }

    private static int[][] fillMatrix(int rows) {
        int[][] matrix = new int[rows][rows];

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < rows; y++) {
                matrix[x][y] = (int) (Math.random() * 10.0);
            }
        }
        return matrix;
    }

    private static void printFullMatrix(int[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            String rowToPrint;
            rowToPrint = "[";
            for (int y = 0; y < matrix.length; y++) {
                rowToPrint = rowToPrint + "" + matrix[x][y];
                rowToPrint = rowToPrint + "-----";
            }
            rowToPrint = rowToPrint + "]";
            System.out.println(rowToPrint);
        }
    }
}
