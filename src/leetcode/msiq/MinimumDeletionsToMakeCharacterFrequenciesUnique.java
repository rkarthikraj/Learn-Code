package leetcode.msiq;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        MinimumDeletionsToMakeCharacterFrequenciesUnique obj = new MinimumDeletionsToMakeCharacterFrequenciesUnique();
        String s1 = "aab";
        String s2 = "aaabbbcc";
        String s3 = "ceabaacb";
        System.out.println("Ans: 0 -- " + obj.minDeletions(s1));
        System.out.println("Ans: 2 -- " + obj.minDeletions(s2));
        System.out.println("Ans: 2 -- " + obj.minDeletions(s3));
    }

    public int minDeletions(String s) {
        int result = 0;
        int[] charCount = new int[26];
        Set<Integer> hs = new HashSet<>();

        for (Character ch : s.toCharArray()) {
            charCount[(int) ch - 'a']++;
        }
//        System.out.println(Arrays.toString(charCount));
//        for (int i = 0; i < 26; i++) {
//            int value = charCount[i];
//            if (!hs.contains(value)) {
//                hs.add(value);
//            } else {
//                while (value > 0) {
//                    result++;
//                    value--;
//                    if (!hs.contains(value)) {
//                        hs.add(value);
//                        break;
//                    }
//                }
//            }
//        }

        for (int value : charCount) {
            while (value != 0 && hs.contains(value)) {
                value--;
                result++;
            }
            hs.add(value);
        }

        return result;
    }
}