package leetcode.msiq;

/*
https://leetcode.com/problems/reverse-words-in-a-string/
Runtime: 5 ms, faster than 72.26% of Java online submissions for Reverse Words in a String.
Memory Usage: 38.5 MB, less than 99.60% of Java online submissions for Reverse Words in a String.
 */

class ReverseWordsInString {
    public static void main(String[] args) {
        ReverseWordsInString obj = new ReverseWordsInString();
        String s = "the sky is blue";
        System.out.println(obj.reverseWords(s));

        String s1 = "  hello world  ";
        System.out.println(obj.reverseWords(s1));

        String s2 = "a good   example";
        System.out.println(obj.reverseWords(s2));
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        s = s.trim();
        String[] strArr = s.split(" ");
        for (int i = strArr.length - 1; i >= 0; --i) {
            if (!strArr[i].trim().isEmpty()) {
                sb.append(strArr[i].trim() + " ");
            }
        }
        return sb.toString().trim();
    }
}