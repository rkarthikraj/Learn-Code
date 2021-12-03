package leetcode.weekly.contest269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] nums = {1, 2, 5, 2, 3};
        int target = 2;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
    }
}
