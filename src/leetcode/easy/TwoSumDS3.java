package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/problems/two-sum-iii-data-structure-design/
Vishnu used hashmap and validated pairs using count, instead of sorting.
Runtime: 140 ms, faster than 41.30% of Java online submissions for Two Sum III - Data structure design.
Memory Usage: 46.3 MB, less than 50.33% of Java online submissions for Two Sum III - Data structure design.
 */
class TwoSumDS3 {
    List<Integer> lst = null;
    public TwoSumDS3() {
        lst = new ArrayList<>();
    }

    public void add(int number) {
        lst.add(number);
        System.out.println(lst);
    }

    public boolean find(int value) {
        Collections.sort(lst);
        int low = 0;
        int high = lst.size() - 1;

        while (low < high && low != high) {
            int check = lst.get(low) + lst.get(high);
            if (check == value) {
                return true;
            } else if (check < value) {
                low++;
            } else {
                high--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TwoSumDS3 obj = null;
        String[] instructions = {"TwoSum", "add", "add", "add", "find", "find"};
        int[][] values = {{}, {1}, {3}, {5}, {4}, {7}};

        for (int i = 0; i < values.length; i++) {
            String instruction = instructions[i];
            switch (instruction) {
                case "TwoSum":
                    obj = new TwoSumDS3();
                    break;
                case "add":
                    obj.add(values[i][0]);
                    break;
                case "find":
                    //obj.find(values[i][0]);
                    System.out.println(obj.find(values[i][0]));
                    break;
            }
        }
    }
}