package a1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A1 {
    public static void main(String[] args) throws IOException {
        int nums = 153;
        while (nums > 0) {
            int n = nums % 10;
            nums /= 10;
            //System.out.println(n);
        }
        double middleElementIndex = Math.floor(5 / 2);
        System.out.println(middleElementIndex);

        List<Integer> result = new ArrayList();
        Queue<Integer> q = new LinkedList();
        q.add(1);
        while (q.isEmpty()){
            q.size();
        }
        // System.out.println("--" + (2 % 4));
    }
}
