package leetcode.others;

import java.util.Map;
import java.util.TreeMap;

class DeleteAndEarn {
    public static void main(String[] args) {
        DeleteAndEarn obj = new DeleteAndEarn();
        int[] nums = {2, 2, 3, 3, 3, 4};
        System.out.println(obj.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        int maxValueInNums = Integer.MIN_VALUE;
        Map<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            tm.put(nums[i], tm.getOrDefault(nums[i], 0) + nums[i]);
            maxValueInNums = Math.max(maxValueInNums, nums[i]);
        }

        //System.out.println("Treemap: " + tm);
        //System.out.println("MaxValueInNums: " + maxValueInNums);

        int[] mem = new int[maxValueInNums + 1];
        mem[0] = 0;
        mem[1] = tm.getOrDefault(1, 0);

        for (int i = 2; i < mem.length; i++) {
            int value = tm.getOrDefault(i, 0);
            mem[i] = Math.max(mem[i - 1], mem[i - 2] + value);
        }

        return mem[maxValueInNums];
    }
}