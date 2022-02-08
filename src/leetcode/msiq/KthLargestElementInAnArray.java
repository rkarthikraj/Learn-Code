package leetcode.msiq;

import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargestElementInAnArray {
    public static void main(String[] args) {
        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(obj.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        return heap.poll();
    }

    public int findKthLargestNaive(int[] nums, int k) {
        int result = -1;

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        for (int i = nums.length - 1; i >= 0; --i) {
            k--;
            if (k == 0) {
                return nums[i];
            }
        }

        return result;
    }
}