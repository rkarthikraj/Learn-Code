package a1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class A1 {
    public static void main(String[] args) throws IOException {
        int nums = 0;
        while (nums > 0) {
            int remainder = nums % 100;
            nums /= 100;
            System.out.println("Remainder: " + remainder + ", Remaining: " + nums);
        }

        //        String path = "/a/b/c/d";
        //        String[] subDirs = path.split("/");
        //        for (int i = 0; i < subDirs.length; i++) {
        //            System.out.println("->" + subDirs[i]);
        //        }

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
//        System.out.println("1%4 :" + (1 % 4));
//        System.out.println("2%4 :" + (2 % 4));
//        System.out.println("3%4 :" + (3 % 4));
//        System.out.println("4%4 :" + (4 % 4));
        System.out.println("0%3 :" + Math.ceil(0 % 3));


        //        int one = (8 / 3) * 3;
        //        int two = 8 / 3;
        //        System.out.println("One: " + one + ", two: " + two);

        //        for (int i = 0; i < 9; i++) {
        //            for (int j = 0; j < 9; j++) {
        //                int idx = (i / 3) * 3 + j / 3;
        //                // System.out.println("R: " + i + " - C: " + j + " - Idx: " + idx);
        //                System.out.print(" " + "R:" + i + ",C:" + j + ",Idx:" + idx);
        //                System.out.print(" | ");
        //            }
        //            System.out.println();
        //        }


        Set<String> hs = new HashSet<>();
        hs.add("a");
        hs.add("a");
        System.out.println(hs);
    }
}
