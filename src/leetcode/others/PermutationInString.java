package leetcode.others;

import java.util.Arrays;

class PermutationInString {
    public static void main(String[] args) {
        PermutationInString obj = new PermutationInString();
        String s1 = "ab";
        String s2 = "eidbaooo";
        //System.out.println(obj.checkInclusion(s1, s2));
        System.out.println(obj.checkInclusionSW(s1, s2));
    }

    public boolean checkInclusionSW(String s1, String s2) {
        int s1LengthWS = s1.length();
        int s2Length = s2.length();

        if (s1LengthWS > s2Length) {
            return false;
        }

        for (int i = 0; i < s2Length; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s1LengthWS + i; ++j) {
                if (j < s2Length) {
                    sb.append(s2.charAt(j));
                    int sbLength = sb.length();
                    if (sbLength == s1LengthWS) {
                        int[] charArray = new int[26];
                        for (int k = 0; k < s1LengthWS; k++) {
                            charArray[s1.charAt(k) - 'a']++;
                        }

                        for (int k = 0; k < s1LengthWS; k++) {
                            charArray[sb.charAt(k) - 'a']--;
                        }

                        if (validateCharArray(charArray)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean validateCharArray(int[] inputArr) {
        for (int i = 0; i < 26; ++i) {
            if (inputArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();

        if (s1Length > s2Length) {
            return false;
        }

        // s1 = "ab";
        // s2 = "eidbaooo";

        int[] s1CharArr = new int[26];
        int[] s2CharArr = new int[26];

        System.out.println(Arrays.toString(s1CharArr));
        System.out.println(Arrays.toString(s2CharArr));

        for (int i = 0; i < s1Length; i++) {
            s1CharArr[s1.charAt(i) - 'a']++;
            s2CharArr[s2.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(s1CharArr));
        System.out.println(Arrays.toString(s2CharArr));

        for (int i = 0; i < (s2Length - s1Length); i++) {
            if (matches(s1CharArr, s2CharArr))
                return true;
            s2CharArr[s2.charAt(i + s1Length) - 'a']++;
            s2CharArr[s2.charAt(i) - 'a']--;
        }

        //        System.out.println(Arrays.toString(s1CharArr));
        //        System.out.println(Arrays.toString(s2CharArr));

        return matches(s1CharArr, s2CharArr);
    }

    private boolean matches(int[] s1, int[] s2) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }
}