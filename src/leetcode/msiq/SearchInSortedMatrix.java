package leetcode.msiq;

/*
https://leetcode.com/problems/search-a-2d-matrix/submissions/
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
Memory Usage: 38.2 MB, less than 90.27% of Java online submissions for Search a 2D Matrix.
 */
class SearchInSortedMatrix {
    public static void main(String[] args) {
        SearchInSortedMatrix obj = new SearchInSortedMatrix();
        // int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix = {{1}, {3}};
        int target = 3;
        System.out.println(obj.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}