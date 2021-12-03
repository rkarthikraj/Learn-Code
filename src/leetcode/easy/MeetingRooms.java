package leetcode.easy;

/*
https://leetcode.com/problems/meeting-rooms/
Runtime: 4 ms, faster than 97.75% of Java online submissions for Meeting Rooms.
Memory Usage: 39 MB, less than 50.36% of Java online submissions for Meeting Rooms.
 */

import java.util.Arrays;
import java.util.Comparator;

class MeetingRoomsSolution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            int nextMeeting = i + 1;
            if (nextMeeting < intervals.length) {
                int startTimeA = intervals[i][0];
                int endTimeA = intervals[i][1];

                int startTimeB = intervals[nextMeeting][0];
                int endTimeB = intervals[nextMeeting][1];

                if (startTimeB < endTimeA) {
                    if (startTimeA >= endTimeB) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

public class MeetingRooms {
    public static void main(String[] args) {
        MeetingRoomsSolution obj = new MeetingRoomsSolution();
        // int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        // int[][] intervals = {{7, 10}, {2, 4}};
        // int[][] intervals = {{13, 15}, {1, 13}};
        int[][] intervals = {{9, 14}, {5, 6}, {3, 5}, {12, 19}};

        System.out.println(obj.canAttendMeetings(intervals));
    }
}
