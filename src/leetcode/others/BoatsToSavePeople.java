package leetcode.others;

import java.util.Arrays;

class BoatsToSavePeople {
    public static void main(String[] args) {
        BoatsToSavePeople obj = new BoatsToSavePeople();
        System.out.println("Output: 4 --> " + obj.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
        System.out.println("Output: 1 --> " + obj.numRescueBoats(new int[]{1, 2}, 3));
        System.out.println("Output: 3 --> " + obj.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println("Output: 2 --> " + obj.numRescueBoats(new int[]{5, 1, 4, 2}, 6));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boatCount = 0;
        int leftIndex = 0;
        int rightIndex = people.length - 1;
        while (leftIndex <= rightIndex) {
            if (people[rightIndex] + people[leftIndex] <= limit) {
                leftIndex++;
            }
            boatCount++;
            rightIndex--;
        }
        return boatCount;
    }
}