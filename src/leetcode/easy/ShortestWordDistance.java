package leetcode.easy;

/*
https://leetcode.com/problems/shortest-word-distance/
 */

import java.util.*;

class ShortestWordDistanceSolution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        if (!word1.equals(word2)) {
            List<Integer> word1Positions = new ArrayList<>();
            List<Integer> word2Positions = new ArrayList<>();

            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    word1Positions.add(i);
                }
                if(wordsDict[i].equals(word2)){
                    word2Positions.add(i);
                }
            }

            System.out.println(word1Positions);
            System.out.println(word1Positions);

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < word1Positions.size(); i++) {
                for (int j = 0; j < word2Positions.size(); j++) {
                    int diff = Math.abs(word1Positions.get(i) - word2Positions.get(j));
                    min = Math.min(min, diff);
                }
            }
            return min;
        }
        return 0;
    }
}

public class ShortestWordDistance {
    public static void main(String[] args) {
        ShortestWordDistanceSolution obj = new ShortestWordDistanceSolution();

        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";

        System.out.println(obj.shortestDistance(wordsDict, word1, word2));
    }
}
