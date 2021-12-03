package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
163. Missing Ranges
Time - 2hrs 30mins
Wrong answer
 */

class MissingRangesSolution {
    List<String> result = new ArrayList<>();

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            print(lower, upper);
            return result;
        }

        if (nums[0] != lower) {
            print(lower, nums[0] - 1);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (diff == 1) {
                continue;
            } else {
                print(nums[i] + 1, diff + nums[i] - 1);
            }
        }

        int lastElement = nums[nums.length - 1];
        if (lastElement != upper) {
            print(lastElement + 1, upper);
        }

        return result;
    }

    void print(int value1, int value2) {
        if (value1 == value2) {
            result.add(value1 + "");
        } else {
            result.add(value1 + "->" + value2);
        }
    }
}

public class MissingRanges {
    public static void main(String[] args) {
        MissingRangesSolution obj = new MissingRangesSolution();

        int[] nums = {1, 5, 6, 50, 75};
        int lower = 0;
        int upper = 99;

        System.out.println(obj.findMissingRanges(nums, lower, upper));
    }
}
