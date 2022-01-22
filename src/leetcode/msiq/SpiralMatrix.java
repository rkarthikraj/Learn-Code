package leetcode.msiq;

import java.util.ArrayList;
import java.util.Arrays;
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
        obj.spiralOrderOptimized(matrix);
        // System.out.println(obj.spiralOrderOptimized(matrix));
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

    public static int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> spiralOrderOptimized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        List<Integer> returnList = new ArrayList();

        int length = m * n;
        int currX = 0;
        int currY = 0;
        int dirPos = 0;

        for (int i = 0; i < length; ++i) {
            //System.out.println(matrix[currX][currY]);
            returnList.add(matrix[currX][currY]);
            visited[currX][currY] = true;

            int newX = currX + DIRS[dirPos][0];
            int newY = currY + DIRS[dirPos][1];

            if (!isValid(newX, newY, m, n, visited)) {
                //dirPos%4;
                dirPos++;
                if (dirPos == 4) {
                    dirPos -= 4;
                }
                newX = currX + DIRS[dirPos][0];
                newY = currY + DIRS[dirPos][1];
            }

            currX = newX;
            currY = newY;
        }

        System.out.println("Visited: " + Arrays.deepToString(visited));
        System.out.println("Result: " + returnList);
        return returnList;
    }

    //    public boolean isValid(int x, int y, int m, int n, boolean[][] visited) {
    //        if (x < 0 || x >= m || y < 0 || y >= n) {
    //            return false;
    //        }
    //        return !visited[x][y];
    //    }

    public boolean isValid(int x, int y, int m, int n, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
            return false;
        }
        return true;
    }
}