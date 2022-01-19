package leetcode.msiq;

import java.util.ArrayList;
import java.util.List;

class MaximumLengthOfConcatenatedStringWithUniqueCharacters {
    public static void main(String[] args) {
        MaximumLengthOfConcatenatedStringWithUniqueCharacters obj = new MaximumLengthOfConcatenatedStringWithUniqueCharacters();
        List<String> arr1 = new ArrayList<>();
        arr1.add("un");
        arr1.add("iq");
        arr1.add("ue");
        System.out.println(obj.maxLength(arr1));

        List<String> arr2 = new ArrayList<>();
        arr2.add("abcdefghijklmnopqrstuvwxyz");
        //System.out.println(obj.maxLength(arr2));
    }

    int MAX_COUNT = 0;
    public int maxLength(List<String> arr) {
        recursive(arr, 0, "");
        return MAX_COUNT;
    }

    public void recursive(List<String> arr, int index, String current) {
        System.out.println(current);

        if (!isValid(current)) {
            return;
        }

        MAX_COUNT = Math.max(MAX_COUNT, current.length());

        if (index == arr.size()) {
            return;
        }

        recursive(arr, index + 1, current + arr.get(index));
        recursive(arr, index + 1, current);
    }

    public boolean isValid(String current) {
        boolean[] frequency = new boolean[26];
        for (char ch : current.toCharArray()) {
            if (frequency[ch - 'a']) {
                return false;
            }
            frequency[ch - 'a'] = true;
        }
        return true;
    }
}