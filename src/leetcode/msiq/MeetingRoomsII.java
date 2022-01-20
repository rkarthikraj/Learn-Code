package leetcode.msiq;

import java.util.Arrays;
import java.util.PriorityQueue;

class MeetingRoomsII {
    public static void main(String[] args) {
        MeetingRoomsII obj = new MeetingRoomsII();
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2 = {{7, 10}, {2, 4}};
        int[][] intervals3 = {{5, 8}, {6, 8}};

        System.out.println(obj.minMeetingRooms(intervals1));
        System.out.println(obj.minMeetingRooms(intervals2));
        System.out.println(obj.minMeetingRooms(intervals3));
    }

    public int minMeetingRooms(int[][] intervals) {
        int meetings = intervals.length;
        if (intervals == null || meetings == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int rooms = 0;

        for (int i = 0; i < meetings; i++) {
            if (!pq.isEmpty() && intervals[i][0] >= pq.peek()) {
                pq.poll();
            } else {
                rooms++;
            }

            pq.add(intervals[i][1]);
        }

        return rooms;
    }
}