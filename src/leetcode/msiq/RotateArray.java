package leetcode.msiq;

import java.util.Arrays;

class RotateArray {
    public static void main(String[] args) {
        RotateArray obj = new RotateArray();
        // int[] nums = {1, 2, 3, 4, 5, 6, 7};
        // int k = 3;

        int[] nums = {-1};
        int k = 2;

        obj.rotate(nums, k);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        //        int[] tempArr = new int[nums.length];
        //        for (int i = 0; i < nums.length; i++) {
        //            tempArr[(i + k) % nums.length] = nums[i];
        //        }
        //        System.out.println(Arrays.toString(tempArr));

        k = k % nums.length;
        System.out.println("Length: " + nums.length);
        System.out.println("K MOD: " + k);

        reverse(nums, 0, nums.length - 1);
        System.out.println("Reverse: " + Arrays.toString(nums));
        reverse(nums, 0, k - 1);
        System.out.println("Reverse only k: " + Arrays.toString(nums));
        reverse(nums, k , nums.length - 1);
        System.out.println("Rotated: " + Arrays.toString(nums));
    }
}