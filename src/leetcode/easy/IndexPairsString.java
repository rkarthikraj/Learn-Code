package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Not solved.
https://leetcode.com/problems/index-pairs-of-a-string/
 */
class IndexPairsString {
    public static void main(String[] args) {
        IndexPairsString obj = new IndexPairsString();
        String text = "ababa";
        String[] words = {"aba", "ab"};

        System.out.println(Arrays.deepToString(obj.indexPairs(text, words)));
    }


    public int[][] indexPairs(String text, String[] words) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (text.contains(words[i])) {
                int wordCounter = 0;
                int windowSize = words[i].length() - 1;
                for (int j = 0; j < text.length(); j++) {
                    int textCounter = j;
                    int matchCounter = 0;
                    while (wordCounter <= windowSize && textCounter < text.length()) {
                        //                        if (words[i].charAt(wordCounter) != text.charAt(textCounter)) {
                        //
                        //                        }

                        // System.out.println("Match Found: " + words[i].charAt(wordCounter) + " - " + text.charAt(textCounter));

                        textCounter++;
                        wordCounter++;
                    }

                    System.out.println("--");
                    wordCounter = 0;
                }
            }
        }
        return new int[][]{};
    }
}
