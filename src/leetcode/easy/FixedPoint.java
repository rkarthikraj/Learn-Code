package leetcode.easy;
/*
https://leetcode.com/problems/fixed-point/
Solved using solution, but the mistake I made was the validation condition.
Need to revise Binary Search and calculation of pivot value.
Runtime: 0 ms, faster than 100.00% of Java online submissions for Fixed Point.
Memory Usage: 38.5 MB, less than 86.21% of Java online submissions for Fixed Point.
 */

class FixedPoint {
    public static void main(String[] args) {
        FixedPoint obj = new FixedPoint();
        int[] arr1 = {-10, -5, 0, 3, 7};
        int[] arr2 = {-10, -5, 2, 3, 7};
        int[] arr3 = {0, 2, 5, 8, 17};
        int[] arr4 = {-10, -5, -2, 0, 4, 5, 6, 7, 8, 9, 10};

        //System.out.println("arr1 - Len:" + arr1.length / 2 + ", 3: " + obj.fixedPoint(arr1));
        //System.out.println("arr2 - Len:" + arr2.length / 2 + ", 2: " + obj.fixedPoint(arr2));
        //System.out.println("arr3 - Len:" + arr3.length / 2 + ", 0: " + obj.fixedPoint(arr3));
        System.out.println("arr4 - Len:" + arr4.length / 2 + ", 4: " + obj.fixedPoint(arr4));
    }

    public int fixedPoint(int[] arr) {
        int result = -1;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == mid) {
                result = mid;
            }

            if (mid <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}