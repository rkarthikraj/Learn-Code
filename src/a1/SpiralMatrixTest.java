package a1;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrixTest {
    public static int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        SpiralMatrixTest obj = new SpiralMatrixTest();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println(obj.spiralOrderOptimized(matrix));
    }

    public List<Integer> spiralOrderOptimized(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int length = rowLength * colLength;

        boolean[][] visited = new boolean[rowLength][colLength];

        int currentX = 0;
        int currentY = 0;
        int dir = 0;
        for (int i = 0; i < length; i++) {
            result.add(matrix[currentX][currentY]);
            visited[currentX][currentY] = true;

            int newX = currentX + DIRS[dir][0];
            int newY = currentY + DIRS[dir][1];

            if(!isValid(newX, newY, rowLength, colLength, visited)) {
                dir++;
                if (dir == 4) {
                    dir -= 4;
                }
                newX = currentX + DIRS[dir][0];
                newY = currentY + DIRS[dir][1];
            }

            currentX = newX;
            currentY = newY;
        }

        return result;
    }

    public boolean isValid(int newX, int newY, int m, int n, boolean[][] visited) {
        if (newX < 0 || newY < 0 || newX >= m || newY >= n || visited[newX][newY]) {
            return false;
        }
        return true;
    }
}