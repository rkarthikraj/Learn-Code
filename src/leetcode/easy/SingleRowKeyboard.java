package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/single-row-keyboard/
Runtime: 6 ms, faster than 56.27% of Java online submissions for Single-Row Keyboard.
Memory Usage: 38.8 MB, less than 93.89% of Java online submissions for Single-Row Keyboard.
 */

class SingleRowKeyboard {
    public static void main(String[] args) {
        SingleRowKeyboard obj = new SingleRowKeyboard();
        System.out.println(obj.calculateTimeOptimize("pqrstuvwxyzabcdefghijklmno", "leetcode"));
        //System.out.println(obj.calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"));
    }

    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            hm.put(keyboard.charAt(i), i);
        }
        // System.out.println(hm);

        int sum = 0;
        int prevCharPos = 0;
        int prevChar = 0;
        for (int i = 0; i < word.length(); ++i) {
            int currChar = word.charAt(i);
            int charPosition = hm.get(word.charAt(i));
            if (prevChar != currChar) {
                prevCharPos = Math.abs(prevCharPos - charPosition);
                sum += prevCharPos;
            }

            //System.out.println(charPosition + " - " + prevCharPos);

            prevCharPos = charPosition;
            prevChar = currChar;
        }
        //System.out.println();

        return sum;
    }

    // Leetcode Best Solution
    public int calculateTimeOptimize(String keyboard, String word) {
        int[] keyIndices = new int[26];

        // Get the index for each key.
        for (int i = 0; i < keyboard.length(); i++)
            keyIndices[keyboard.charAt(i) - 'a'] = i;

        System.out.println(Arrays.toString(keyIndices));
        // Initialize previous index as starting index = 0.
        int prev = 0;
        int result = 0;

        // Calculate the total time.
        for (char c : word.toCharArray()) {
            // Add the distance from previous index
            // to current letter's index to the result.
            result += Math.abs(prev - keyIndices[c - 'a']);

            // Update the previous index to current index for next iteration.
            prev = keyIndices[c - 'a'];
        }
        return result;
    }
}