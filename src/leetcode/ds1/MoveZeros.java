package leetcode.ds1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class MoveZeros {
    public static void main(String[] args) {
        MoveZeros obj = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};
        obj.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        if(nums.length > 1) {
            List<Integer> lst = new LinkedList<>();
            int countZeros = 0;

            for (int n : nums) {
                if (n == 0) {
                    countZeros++;
                } else {
                    lst.add(n);
                }
            }

            for (int i = 0; i < lst.size(); i++) {
                nums[i] = lst.get(i);
            }

            Arrays.fill(nums, lst.size(), nums.length, 0);
        }
    }
}