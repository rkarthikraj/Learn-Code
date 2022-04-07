package leetcode.dp;

import java.util.HashMap;

/*
https://leetcode.com/explore/learn/card/dynamic-programming/631/strategy-for-solving-dp-problems/4096/
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();

        System.out.println(obj.climbStairsIteration(0));
        System.out.println(obj.climbStairsIteration(1));
        System.out.println(obj.climbStairsIteration(2));
        System.out.println(obj.climbStairsIteration(3));
        System.out.println(obj.climbStairsIteration(4));
        System.out.println(obj.climbStairsIteration(5));
        System.out.println(obj.climbStairsIteration(45));
        System.out.println(obj.climbStairsRecurrsion(45));
    }

    private HashMap<Integer, Integer> memo = new HashMap<>();

    private int climbStairsRecurrsion(int i) {
        if (i <= 2) return i;
        // Instead of just returning dp(i - 1) + dp(i - 2), calculate it once and then
        // store it inside a hashmap to refer to in the future
        if (!memo.containsKey(i)) {
            memo.put(i, climbStairsRecurrsion(i - 1) + climbStairsRecurrsion(i - 2));
        }

        return memo.get(i);
    }


    public long climbStairsIteration(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        long[] nums = new long[n + 1];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }

        return nums[n];
    }
}
