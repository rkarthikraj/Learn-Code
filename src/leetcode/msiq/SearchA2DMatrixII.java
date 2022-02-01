package leetcode.msiq;

class SearchA2DMatrixII {
    public static void main(String[] args) {
        SearchA2DMatrixII obj = new SearchA2DMatrixII();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(obj.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = (m * n) - 1;

        System.out.println("Start: " + left + ", End: " + right);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            }

            if (matrix[mid / n][mid % n] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public boolean searchMatrixNaive(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;

        for (int i = m; i >= 0; --i) {
            for (int j = n; j >= 0; --j) {
                if (target == matrix[i][j]) {
                    return true;
                } else if (target > matrix[i][j]) {
                    m++;
                    continue;
                }
            }
        }
        return false;
    }
}