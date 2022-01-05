package a1;

import java.io.IOException;

public class A1 {
    public static void main(String[] args) throws IOException {
        int nums = 0;
        while (nums > 0) {
            int remainder = nums % 100;
            nums /= 100;
            System.out.println("Remainder: " + remainder + ", Remaining: " + nums);
        }
        //        double middleElementIndex = Math.floor(5 / 2);
        //        System.out.println(middleElementIndex);
        //
        //        List<Integer> result = new ArrayList();
        //        Queue<Integer> q = new LinkedList();
        //        q.add(1);
        //        while (q.isEmpty()){
        //            q.size();
        //        }
        //         System.out.println("--" + (2 % 4));

        //System.out.println((double) 3/7);
        //System.out.println(3%7);

        int one = (8 / 3) * 3;
        int two = 8 / 3;
        System.out.println("One: " + one + ", two: " + two);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int idx = (i / 3) * 3 + j / 3;
                // System.out.println("R: " + i + " - C: " + j + " - Idx: " + idx);
                System.out.print(" " + "R:" + i + ",C:" + j + ",Idx:" + idx);
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
