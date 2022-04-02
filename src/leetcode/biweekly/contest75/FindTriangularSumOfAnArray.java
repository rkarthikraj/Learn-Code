package leetcode.biweekly.contest75;

import java.util.ArrayList;
import java.util.List;

class FindTriangularSumOfAnArray {
    public static void main(String[] args) {
        FindTriangularSumOfAnArray obj = new FindTriangularSumOfAnArray();
        System.out.println(obj.triangularSum(new int[]{1, 2, 3, 4, 5}));
        System.out.println(obj.triangularSum(new int[]{5}));
    }

    public int triangularSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int length = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            list.add(nums[i]);
        }

        recurrsiveSum(list);

//        System.out.println("Num List: " + list);
//        System.out.println("Resultant List: " + recurrsiveSum(list));

        return list.get(0);
    }

    public List<Integer> recurrsiveSum(List<Integer> list) {
        if (list.size() == 1) {
            return list;
        }

        int i = 0;
        int size = list.size();
        int breakCheck = list.size();
        while (size > 1) {
            if ((i + 1) < breakCheck) {
                int sum = list.get(i) + list.get(i + 1);
                list.add(sum % 10);
                i++;
                size--;
            }
        }

        list.subList(0, (i + 1)).clear();
        recurrsiveSum(list);

        return list;
    }
}