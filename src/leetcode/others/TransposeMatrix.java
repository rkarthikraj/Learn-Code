package leetcode.others;

import java.util.Arrays;

class TransposeMatrix {
    public static void main(String[] args) {
        TransposeMatrix obj = new TransposeMatrix();
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(obj.transpose(matrix1)));
        System.out.println(Arrays.deepToString(obj.transpose(matrix2)));
    }

    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] result = new int[column][row];

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                //System.out.print("\t" + matrix[j][i]);
                result[i][j] = matrix[j][i];
            }
            //System.out.println();
        }
        return result;
    }
}