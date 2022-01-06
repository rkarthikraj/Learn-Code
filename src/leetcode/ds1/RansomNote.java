package leetcode.ds1;

import java.util.Arrays;

class RansomNote {
    public static void main(String[] args) {
        RansomNote obj = new RansomNote();
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(obj.canConstructOptimize(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomeCount = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            ransomeCount[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            ransomeCount[magazine.charAt(i) - 'a']--;
        }

        System.out.println(Arrays.toString(ransomeCount));

        for (int i = 0; i < ransomeCount.length; i++) {
            if (ransomeCount[i] > 0) {
                return false;
            }
        }

        return true;
    }

    public boolean canConstructOptimize(String ransomNote, String magazine) {
        int[] ransomeCount = new int[26];

        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] magazineCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            magazineCount[magazine.charAt(i) - 'a']++;
        }

        for(char c : ransomNote.toCharArray()){
            magazineCount[c - 'a']--;
            if (magazineCount[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}