package leetcode.msiq;

import java.util.ArrayList;
import java.util.List;

class Triangle {
    public static void main(String[] args) {
        Triangle obj = new Triangle();
        List<List<Integer>> lst = new ArrayList<>();

        List<Integer> innerList1 = new ArrayList<>();
        innerList1.add(-10);

        //        List<Integer> innerList2 = new ArrayList<>();
        //        innerList2.add(3);
        //        innerList2.add(4);
        //
        //        List<Integer> innerList3 = new ArrayList<>();
        //        innerList3.add(6);
        //        innerList3.add(5);
        //        innerList3.add(7);
        //
        //        List<Integer> innerList4 = new ArrayList<>();
        //        innerList4.add(4);
        //        innerList4.add(1);
        //        innerList4.add(8);
        //        innerList4.add(3);

        lst.add(innerList1);
        //        lst.add(innerList2);
        //        lst.add(innerList3);
        //        lst.add(innerList4);

        obj.minimumTotal(lst);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int result = 0;

        for (int i = 0; i < triangle.size(); i++) {
            int min = Integer.MAX_VALUE;
            List<Integer> values = triangle.get(i);
            System.out.println(values);
            for (int value : values) {
                min = Math.min(value, min);
            }
            result += min;
        }

        System.out.println("Result: " + result);
        return result;
    }
}