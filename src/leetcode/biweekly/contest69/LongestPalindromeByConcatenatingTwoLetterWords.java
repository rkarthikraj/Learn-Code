package leetcode.biweekly.contest69;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LongestPalindromeByConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        LongestPalindromeByConcatenatingTwoLetterWords obj = new LongestPalindromeByConcatenatingTwoLetterWords();
        String[] words1 = {"lc", "cl", "gg"};

        System.out.println(obj.longestPalindrome(words1));
    }

    public int longestPalindrome(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int result = 0;
        Map<String, Integer> hm = new HashMap<>();
        Set<String> hs = new HashSet<>();

        for (String word : words) {
            if (word.charAt(0) == word.charAt(1)) {
                hs.add(word);
            }

            String rev = "" + word.charAt(1) + word.charAt(0);

            if (hm.containsKey(rev)) {
                result += 4;

                hm.put(rev, hm.get(rev) - 1);

                if (hm.get(rev) == 0) {
                    hm.remove(rev);
                }

                if (hs.contains(rev)) {
                    hs.remove(rev);
                }

            } else {
                if (hm.containsKey(word)) {
                    hm.put(word, hm.get(word) + 1);
                } else {
                    hm.put(word, 1);
                }
            }
        }

        if (!hs.isEmpty()) {
            result += 2;
        }
        return result;
    }
}