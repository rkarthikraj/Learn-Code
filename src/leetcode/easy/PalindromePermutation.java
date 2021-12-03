package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/palindrome-permutation/
Runtime: 1 ms, faster than 39.53% of Java online submissions for Palindrome Permutation.
Memory Usage: 36.9 MB, less than 70.40% of Java online submissions for Palindrome Permutation.
 */
class PalindromePermutationSolution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer value = hm.get(c);
            if (value == null) {
                hm.put(c, 1);
            } else {
                hm.put(c, value + 1);
            }
        }

        int counter = 0;
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            int value = entry.getValue();
            if ((value % 2) != 0) {
                counter++;
            }
            if (counter > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean canPermutePalindromeOptimize(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a'] += 1;
        }

        int singleCounter = 0;
        for (int count : arr) {
            singleCounter += count % 2;

            if(singleCounter > 1){
                return false;
            }
        }

        return true;
    }
}

public class PalindromePermutation {
    public static void main(String[] args) {
        PalindromePermutationSolution obj = new PalindromePermutationSolution();
        String str = "carerac";
        System.out.println(obj.canPermutePalindrome(str));
    }
}
