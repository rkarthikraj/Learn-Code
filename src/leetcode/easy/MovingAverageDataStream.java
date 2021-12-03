package leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/moving-average-from-data-stream/
Runtime: 96 ms, faster than 11.35% of Java online submissions for Moving Average from Data Stream.
Memory Usage: 44.4 MB, less than 31.36% of Java online submissions for Moving Average from Data Stream.
 */

class MovingAverageSolution {
    int size;
    int counter = 0;
    List<Integer> data;
    Queue<Integer> q;
    double sum = 0;

    //    public double next(int val) {
    //        data.add(val);
    //        // System.out.println("List size -> " + data.size());
    //        double sum = 0;
    //        if (data.size() > size) {
    //            counter = data.size() - size;
    //        }
    //
    //        for (int i = counter; i < data.size(); i++) {
    //            sum += data.get(i);
    //            System.out.print("\t" + data.get(i));
    //        }
    //
    //        System.out.println();
    //        if (data.size() <= size) {
    //            System.out.println("Sum -> " + sum + " data.size() -> " + data.size());
    //            System.out.println((double) sum / data.size());
    //            return sum / data.size();
    //        } else {
    //            System.out.println("Sum -> " + sum + " size -> " + size);
    //            System.out.println((double) sum / size);
    //            return sum / size;
    //        }
    //    }

    public MovingAverageSolution(int size) {
        // data = new ArrayList<>();
        this.size = size;
        q = new LinkedList<>();
    }

    public double nextOptimize(int val) {
        if (q.size() == size) {
            sum -= q.remove();
        }

        q.add(val);
        sum += val;
        return sum / q.size();
    }
}

public class MovingAverageDataStream {
    public static void main(String[] args) {
        MovingAverageSolution obj = null;

        //String[] instructions = {"MovingAverage", "next", "next", "next", "next"};
        //int[][] dataStream = {{3}, {1}, {10}, {3}, {5}};

        String[] instructions = {"MovingAverage", "next", "next", "next"};
        int[][] dataStream = {{2}, {-50}, {100}, {50}};

        for (int i = 0; i < instructions.length; i++) {
            String instruction = instructions[i];

            switch (instruction) {
                case "MovingAverage":
                    obj = new MovingAverageSolution(dataStream[i][0]);
                    break;
                case "next":
                    obj.nextOptimize(dataStream[i][0]);
                    break;
            }
        }
    }
}
