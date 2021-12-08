package leetcode.msiq;

import java.util.Arrays;

/*
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/
Runtime: 10 ms, faster than 60.63% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
Memory Usage: 55.7 MB, less than 10.93% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
 */

class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        KthSmallestElementInSortedMatrix obj = new KthSmallestElementInSortedMatrix();

        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;

        System.out.println(obj.kthSmallest(matrix, k));

    }

    public int kthSmallest(int[][] matrix, int k) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        int matrixLength = rowLength * columnLength;
        int[] arr1D = new int[matrixLength];

        //        for (int i = 0; i < rowLength; i++) {
        //            for (int j = 0; j < matrix[i].length; j++) {
        //                System.out.print("\t" + matrix[i][j]);
        //            }
        //            System.out.println();
        //        }
        //        System.out.println("-------------------------------");

        //        int left = 0;
        //        int right = rowLength * columnLength - 1;
        //        int mid = left + (right - left) / 2;

        //        System.out.println("rowLength: " + rowLength);
        //        System.out.println("columnLength: " + columnLength);
        //
        //        System.out.println("Left: " + left);
        //        System.out.println("Right: " + right);
        //        System.out.println("Mid: " + mid);


        for (int i = 0; i < matrixLength; i++) {
            //System.out.println("Row: " + i / columnLength + ", Column: " + i % columnLength);
            arr1D[i] = matrix[i / columnLength][i % columnLength];
        }

        Arrays.sort(arr1D);
        System.out.println(Arrays.toString(arr1D));
        return arr1D[k - 1];
    }
}