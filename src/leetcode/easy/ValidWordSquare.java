package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/valid-word-square/
Runtime: 4 ms, faster than 90.59% of Java online submissions for Valid Word Square.
Memory Usage: 38.7 MB, less than 71.04% of Java online submissions for Valid Word Square.
 */

class ValidWordSquare {
    public static void main(String[] args) {
        ValidWordSquare obj = new ValidWordSquare();
        List<String> words = new ArrayList<>();
        words.add("abcd");
        words.add("bnrt");
        words.add("crmy");
        words.add("dtye");

        //        words.add("abcd");
        //        words.add("bnrt");
        //        words.add("crm");
        //        words.add("dt");

        //        words.add("ball");
        //        words.add("area");
        //        words.add("read");
        //        words.add("lady");

        //        words.add("ball");
        //        words.add("asee");
        //        words.add("let");
        //        words.add("lep");

        System.out.println(obj.validWordSquare(words));
    }

    public boolean validWordSquare(List<String> words) {
        int listSize = words.size();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (!word.equals(crossWord(words, i))) {
                return false;
            }
        }
        return true;
    }

    public String crossWord(List<String> words, int coloumnNumber) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.length() > coloumnNumber) {
                sb.append(word.charAt(coloumnNumber));
            }
        }
        return sb.toString();
    }
}