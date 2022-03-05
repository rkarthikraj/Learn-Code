package leetcode.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class DeleteAndEarn {
    public static void main(String[] args) {
        DeleteAndEarn obj = new DeleteAndEarn();
        int[] nums = {2, 2, 3, 3, 3, 4};
        System.out.println(obj.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> tm = new TreeMap<>();
        List<Integer> keyLookup = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            tm.put(nums[i], tm.getOrDefault(nums[i], 0) + 1);
            if (!keyLookup.contains(nums[i])) {
                keyLookup.add(nums[i]);
            }
        }

        System.out.println(tm);
        System.out.println(keyLookup);
        int count = 0;
        for (int i = 0; i < keyLookup.size(); i++) {
            Map<Integer, Integer> tempTM = tm;
            int key = keyLookup.get(i);
            int prev = key - 1;
            int next = key + 1;
            count = key * tempTM.get(key);
            tempTM.remove(key);
            tempTM.remove(prev);
            tempTM.remove(next);
            count += counter(tempTM);
            max = Math.max(count, max);
        }

        return max;
    }

    public int counter(Map<Integer, Integer> tm) {
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            count += (key * value);
        }
        return count;
    }
}