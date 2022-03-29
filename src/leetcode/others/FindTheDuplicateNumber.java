package leetcode.others;

import java.util.HashSet;
import java.util.Set;

class FindTheDuplicateNumber {
    public static void main(String[] args) {
        FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
        System.out.println(obj.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(obj.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    public int findDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return nums[i];
            }
        }

        return 0;
    }

    public int findDuplicate(int[] nums) {
        int length = nums.length;
        boolean[] numberBool = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (numberBool[nums[i]]) {
                return nums[i];
            }
            numberBool[nums[i]] = true;
        }
        return -1;
    }
}