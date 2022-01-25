package leetcode.curator;

import java.util.Arrays;

class RangeAddition {
    public static void main(String[] args) {
        RangeAddition obj = new RangeAddition();
        int length1 = 5;
        int[][] updates1 = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        System.out.println("Result [-2,0,3,5,3] --> " + Arrays.toString(obj.getModifiedArray(length1, updates1)));

        int length2 = 10;
        int[][] updates2 = {{2, 4, 6}, {5, 6, 8}, {1, 9, -4}};
        System.out.println("Result [0,-4,2,2,2,4,4,-4,-4,-4] --> " + Arrays.toString(obj.getModifiedArray(length2, updates2)));
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] modifiedArray = new int[length];

        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int increment = updates[i][2];

            while (start <= end) {
                modifiedArray[start] += increment;
                start++;
            }
        }

        return modifiedArray;
    }
}