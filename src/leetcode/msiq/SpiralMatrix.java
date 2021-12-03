package leetcode.msiq;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/spiral-matrix/
Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
Memory Usage: 37 MB, less than 94.66% of Java online submissions for Spiral Matrix.
 */

class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix obj = new SpiralMatrix();
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(obj.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int matrixSize = matrix[0].length * matrix.length;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (result.size() < matrixSize) {

            for (int i = left; i <= right && result.size() < matrixSize; i++) {
                result.add(matrix[top][i]);
            }

            top++;

            for (int i = top; i <= bottom && result.size() < matrixSize; i++) {
                result.add(matrix[i][right]);
            }

            right--;

            for (int i = right; i >= left && result.size() < matrixSize; i--) {
                result.add(matrix[bottom][i]);
            }

            bottom--;

            for (int i = bottom; i >= top && result.size() < matrixSize; i--) {
                result.add(matrix[i][left]);
            }

            left++;
        }
        return result;
    }
}