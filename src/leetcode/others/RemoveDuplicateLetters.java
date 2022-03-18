package leetcode.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RemoveDuplicateLetters {
    public static void main(String[] args) {
        RemoveDuplicateLetters obj = new RemoveDuplicateLetters();
        String s1 = "bcabc";
        String s2 = "cbacdcbc";
        String s3 = "abacb";
        System.out.println(obj.removeDuplicateLetters(s1));
        System.out.println(obj.removeDuplicateLetters(s2));
        System.out.println(obj.removeDuplicateLetters(s3));
    }

    public String removeDuplicateLetters(String s) {
        StringBuilder resultSB = new StringBuilder();
        int length = s.length();
        Map<Character, Integer> lastPositionHM = new HashMap<>();
        for (int i = 0; i < length; i++) {
            lastPositionHM.put(s.charAt(i), i);
        }

        List<Character> resultList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (resultList.size() == 0) {
                resultList.add(currentChar);
            } else {
                int listSize = resultList.size();
                for (int j = listSize - 1; j >= 0; j--) {
                    char existingChar = resultList.get(j);
                    int existingCharLexicalValue = existingChar - 'a';
                    int currentCharLexicalValue = currentChar - 'a';
                    if (!resultList.contains(currentChar)) {
                        if (currentCharLexicalValue < existingCharLexicalValue && lastPositionHM.get(existingChar) > i) {
                            resultList.remove(j);
                        } else {
                            break;
                        }
                    }
                }
                if (!resultList.contains(currentChar)) {
                    resultList.add(currentChar);
                }
            }
        }

        for (Character charValue : resultList) {
            resultSB.append(charValue);
        }

        return resultSB.toString();
    }
}