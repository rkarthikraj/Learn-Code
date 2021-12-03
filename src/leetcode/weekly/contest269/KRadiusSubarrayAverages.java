package leetcode.weekly.contest269;

import java.util.Arrays;

/*
Wrong answer / Time limit exceeded
 */
public class KRadiusSubarrayAverages {
    public static void main(String[] args) {
        KRadiusSubarrayAverages obj = new KRadiusSubarrayAverages();
        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
        int k = 3;

        obj.getAverages(nums, k);
    }

    public int[] getAverages(int[] nums, int k) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        int left = 0;
        int right = nums.length;

        int radius1 = k;
        int radius2 = 2 * k;
        while (left < right && radius1 <= right) {
            int leftCount = 0;
            int rightCount = 0;

            int leftSum = 0;
            int rightSum = 0;

            System.out.print("Left -> ");
            for (int i = left; i < radius1; i++) {
                leftSum += nums[i];
                leftCount++;
                System.out.print("\t" + nums[i]);
            }
            System.out.println();

            System.out.print("Right -> ");
            if (radius2 < right) {
                for (int i = radius1 + 1; i <= radius2; i++) {
                    rightSum += nums[i];
                    rightCount++;
                    System.out.print("\t" + nums[i]);
                }
            }
            System.out.println();

            if (leftCount == k && rightCount == k) {
                int avg = (leftSum + nums[radius1] + rightSum) / (leftCount + rightCount + 1);
                result[radius1] = avg;
            }

            System.out.println("Left: " + left + ", Right: " + radius2);
            System.out.println("Left Count: " + leftCount + "\t Right Count: " + rightCount);
            System.out.println();

            left++;
            radius1++;
            radius2++;
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(result));
        return result;
    }
}
