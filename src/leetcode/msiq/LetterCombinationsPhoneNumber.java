package leetcode.msiq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsPhoneNumber obj = new LetterCombinationsPhoneNumber();
        String digits = "2";
        System.out.println(obj.letterCombinations(digits).size());
        System.out.println(obj.letterCombinations(digits));
    }

    public void construct(String keyValue, List<String> result, Queue<String> q, int tracker) {
        if (tracker == 0) {
            for (int i = 0; i < keyValue.length(); i++) {
                q.add(keyValue.charAt(i) + "");
                result.add(keyValue.charAt(i) + "");
            }
            return;
        }

        int counter = 0;
        while (!q.isEmpty()) {
            String value = q.poll();
            for (int j = 0; j < keyValue.length(); j++) {
                String temp = value;
                temp += keyValue.charAt(j);
                result.add(temp);
            }
            counter++;
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        Queue<String> q = new LinkedList<String>();
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        String temp = "";
        int tracker = 0;
        char[] chArr = digits.toCharArray();
        if (chArr.length > 0) {
            for (char c : chArr) {
                result.clear();
                String keyValue = letters[Character.getNumericValue(c)];
                construct(keyValue, result, q, tracker);
                q.clear();
                q.addAll(result);
                tracker++;
            }
            q.clear();
        }

        return result;
    }
}


// DFS Solution
/*
class LetterCombinationsPhoneNumberSolution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();

        if (digits != null && digits.length() > 0) {
            String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
            dfs(digits, map, result, new StringBuilder(), 0);
        }

        System.out.println(result.size());
        return result;
    }

    public void dfs(String digits, String[] map, ArrayList<String> result, StringBuilder sb, int index) {
        System.out.println("digits -> " + digits + ", result -> " + result + ", sb -> " + sb + ", index -> " + index);

        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int digit = Character.getNumericValue(digits.charAt(index));
        String letters = map[digit];

        for (int i = 0; i < letters.length(); ++i) {
            char ch = letters.charAt(i);
            sb.append(ch);
            dfs(digits, map, result, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}*/
