package leetcode.ds1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class ReshapeMatrix {
    public static void main(String[] args) {
        ReshapeMatrix obj = new ReshapeMatrix();
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 4;
        int c = 1;
        System.out.println(Arrays.deepToString(obj.matrixReshape(mat, r, c)));
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rowLength = mat.length;
        int colLength = mat[0].length;

        if ((r * c) != (rowLength * colLength)) {
            return mat;
        }
        int[][] resultantMatrix = new int[r][c];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                q.add(mat[i][j]);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                resultantMatrix[i][j] = q.poll();
            }
        }

        return resultantMatrix;
    }
}