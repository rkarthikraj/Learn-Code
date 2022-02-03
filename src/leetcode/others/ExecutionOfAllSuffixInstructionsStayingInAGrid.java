package leetcode.others;

import java.util.Arrays;

class ExecutionOfAllSuffixInstructionsStayingInAGrid {
    public static void main(String[] args) {
        ExecutionOfAllSuffixInstructionsStayingInAGrid obj = new ExecutionOfAllSuffixInstructionsStayingInAGrid();
        int n1 = 3;
        int[] startPos1 = {0, 1};
        String s1 = "RRDDLU";
        System.out.println(Arrays.toString(obj.executeInstructions(n1, startPos1, s1)));

        int n2 = 2;
        int[] startPos2 = {1, 1};
        String s2 = "LURD";
        System.out.println(Arrays.toString(obj.executeInstructions(n2, startPos2, s2)));
    }

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int length = s.length();
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            String moves = s.substring(i, length);
            // System.out.println(moves);
            int count = 0;
            int row = startPos[0];
            int column = startPos[1];
            for (int j = i; j < length; j++) {
                char ch = s.charAt(j);

                if (ch == 'L') {
                    column--;
                } else if (ch == 'R') {
                    column++;
                } else if (ch == 'D') {
                    row++;
                } else if (ch == 'U') {
                    row--;
                }

                if (row >= 0 && row < n && column >= 0 && column < n) {
                    count++;
                } else {
                    break;
                }
            }
            result[i] = count;
        }

        return result;
    }

}