package leetcode.easy;

/*
https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
Runtime: 1 ms, faster than 47.51% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
Memory Usage: 39.4 MB, less than 64.01% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
 */
class CountNegativeNumbersInSortedMatrix {
    public static void main(String[] args) {
        CountNegativeNumbersInSortedMatrix obj = new CountNegativeNumbersInSortedMatrix();
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        obj.countNegatives(grid);
    }

    public int countNegatives(int[][] grid) {
        int rowLength = grid.length - 1;
        int columnLength = grid[0].length - 1;

        int row = rowLength;
        int column = columnLength;

        int count = 0;
        while (row >= 0) {
            if (column >= 0 && grid[row][column] < 0) {
                count++;
                column--;
            } else {
                row--;
                column = columnLength;
            }
        }

        System.out.println(count);
        return count;
    }
}