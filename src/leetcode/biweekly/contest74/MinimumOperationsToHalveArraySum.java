package leetcode.biweekly.contest74;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

class MinimumOperationsToHalveArraySum {
    public static void main(String[] args) {
        MinimumOperationsToHalveArraySum obj = new MinimumOperationsToHalveArraySum();
        int[] nums1 = {5, 19, 8, 1};
        int[] nums2 = {3, 8, 20};
        int[] nums3 = {92, 91, 55, 74, 98, 45, 94, 99, 35, 28, 78, 10, 27, 55, 93, 93, 33, 76, 14, 27, 82, 11, 5, 58, 96, 70, 31, 6};

        System.out.println(obj.halveArray(nums1));
        System.out.println(obj.halveArray(nums2));
        System.out.println(obj.halveArray(nums3));
    }

    public int halveArray(int[] nums) {
        double totalSum = 0;
        TreeSet<Double> treeSet = new TreeSet<>();
        Queue<Double> queue = new PriorityQueue(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            treeSet.add(nums[i] * 1.0d);
            queue.add(nums[i] * 1.0d);
        }

        double remainingSum = totalSum;
        int count = 0;

        while (remainingSum > totalSum / 2) {
            count++;
            // double numHalfValue = treeSet.pollLast() / 2.0d;
            double numHalfValue = queue.poll() / 2.0d;
            remainingSum -= numHalfValue;
            // treeSet.add(numHalfValue);
            queue.add(numHalfValue);
        }

        return count;
    }
}