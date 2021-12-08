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
        System.out.println(obj.searchMatrixBinarySearch(matrix, target));
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

    public boolean searchMatrixBinarySearch(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        int left = 0;
        int right = rowLength * columnLength - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / columnLength][mid % columnLength] == target) {
                return true;
            }

            if (matrix[mid / columnLength][mid % columnLength] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}