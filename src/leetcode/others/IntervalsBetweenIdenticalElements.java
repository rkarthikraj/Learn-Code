package leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class IntervalsBetweenIdenticalElements {
    public static void main(String[] args) {
        IntervalsBetweenIdenticalElements obj = new IntervalsBetweenIdenticalElements();
        int[] arr1 = {2, 1, 3, 1, 2, 3, 3};
        int[] arr2 = {10, 5, 10, 10};

        System.out.println(Arrays.toString(obj.getDistances(arr1)));
        System.out.println(Arrays.toString(obj.getDistances(arr2)));
    }

    public long[] getDistances(int[] arr) {
        int arrLength = arr.length;
        Map<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < arrLength; i++) {
            ArrayList<Integer> valueList = hm.get(arr[i]);
            if (valueList == null) {
                valueList = new ArrayList<>();
                hm.put(arr[i], valueList);
            }
            valueList.add(i);
        }

        // System.out.println(hm);
        long[] result = new long[arrLength];
        for (int i = 0; i < arrLength; i++) {
            ArrayList<Integer> values = hm.get(arr[i]);
            // System.out.println(arr[i] + "--" + values.size() + "--" + values);
            long sum = 0;
            for (int value : values) {
                if (value != i) {
                    sum += Math.abs(i - value);
                }
            }

            result[i] = sum;
        }

        return result;
    }
}