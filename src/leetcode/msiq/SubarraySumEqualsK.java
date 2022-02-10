package leetcode.msiq;

import java.util.HashMap;

class SubarraySumEqualsK {
    public static void main(String[] args) {
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        int[] nums = {1, 2, 1, 2, 1};
        int k = 3;
        System.out.println(obj.subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                //System.out.print("\t" + nums[j]);
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
            //System.out.println();
        }

        return count;
    }

    public int subarraySumOptimized(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}