package leetcode.dp;

import java.util.Arrays;

class HouseRobber {
    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
        System.out.println(obj.rob(new int[]{10, 5, 20, 100, 1}));
        System.out.println(obj.rob(new int[]{1, 2, 3, 1}));
        System.out.println(obj.rob(new int[]{1, 2}));
        System.out.println(obj.rob(new int[]{0}));
    }

    public int rob(int[] nums) {
        int length = nums.length;

        if (length == 0) {
            return 0;
        }

        if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        System.out.println(Arrays.toString(dp));

        return dp[length - 1];
    }
}