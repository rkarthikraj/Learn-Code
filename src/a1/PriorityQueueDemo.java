package a1;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] array = {10, -1, 100, 21, -99, 10, 0, 19999, 20221, 100};

        for (int i = 0; i < array.length; i++) {
            pq.add(array[i]);
            System.out.println(pq);
        }
    }
}
