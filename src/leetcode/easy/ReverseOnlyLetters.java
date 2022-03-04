package leetcode.easy;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String s = "a-BC-DEf-ghIj";

        char[] sCharArr = s.toCharArray();
        int left = 0;
        int right = sCharArr.length - 1;
        while (left <= right) {
            if (!Character.isAlphabetic(sCharArr[left])) {
                left++;
            } else if (!Character.isAlphabetic(sCharArr[right])) {
                right--;
            } else {
                char temp = sCharArr[left];
                sCharArr[left] = sCharArr[right];
                sCharArr[right] = temp;

                left++;
                right--;
            }
        }

        System.out.println(new String(sCharArr));
    }
}
