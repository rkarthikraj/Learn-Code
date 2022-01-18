package leetcode.msiq;

import java.util.Arrays;

class ReverseWords {
    public static void main(String[] args) {
        ReverseWords obj = new ReverseWords();
        char[] s = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        obj.reverseWords(s);
    }

    public void reverseWords(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char tempCh = s[left];
            s[left] = s[right];
            s[right] = tempCh;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(s));

        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                int temp = i - 1;
                int right1 = temp;

                while (temp >= 0 && s[temp] != ' ') {
                    temp--;
                }

                int left1 = temp + 1;

                // SWAP
                while (left1 < right1) {
                    char tempCh = s[left1];
                    s[left1] = s[right1];
                    s[right1] = tempCh;
                    left1++;
                    right1--;
                }
            }

            if (i == s.length - 1) {
                int temp = i;
                int right1 = temp;
                while (temp >= 0 && s[temp] != ' ') {
                    temp--;
                }

                int left1 = temp + 1;

                // SWAP
                while (left1 < right1) {
                    char tempCh = s[left1];
                    s[left1] = s[right1];
                    s[right1] = tempCh;
                    left1++;
                    right1--;
                }
            }
        }

        System.out.println(Arrays.toString(s));
    }

    public void reverseEachWords(char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                int temp = i - 1;
                int right = temp;

                while (temp >= 0 && s[temp] != ' ') {
                    //System.out.print(s[temp]);
                    temp--;
                }
                int left = temp + 1;
                System.out.println("Left: " + left + ", Right: " + right);

                // SWAP
                while (left < right) {
                    char tempCh = s[left];
                    s[left] = s[right];
                    s[right] = tempCh;
                    left++;
                    right--;
                }
            }

            if (i == s.length - 1) {
                int temp = i;
                int right = temp;
                while (temp >= 0 && s[temp] != ' ') {
                    //System.out.print(s[temp]);
                    temp--;
                }
                int left = temp + 1;
                System.out.println("Left: " + left + ", Right: " + right);

                // SWAP
                while (left < right) {
                    char tempCh = s[left];
                    s[left] = s[right];
                    s[right] = tempCh;
                    left++;
                    right--;
                }
            }
        }

        System.out.println(Arrays.toString(s));
    }
}