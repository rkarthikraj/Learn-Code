package leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PartitionArrayAccordingToGivenPivot {
    public static void main(String[] args) {
        PartitionArrayAccordingToGivenPivot obj = new PartitionArrayAccordingToGivenPivot();
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;
        System.out.println(Arrays.toString(obj.pivotArray(nums, pivot)));
    }

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int same = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                less.add(nums[i]);
            } else if (nums[i] == pivot) {
                same++;
            } else if (nums[i] > pivot) {
                greater.add(nums[i]);
            }
        }

        int index = 0;
        for (int i = 0; i < less.size(); i++) {
            nums[index++] = less.get(i);
        }

        for (int i = 0; i < same; i++) {
            nums[index++] = pivot;
        }

        for (int i = 0; i < greater.size(); i++) {
            nums[index++] = greater.get(i);
        }

        return nums;
    }
}