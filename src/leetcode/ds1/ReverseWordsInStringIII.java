package leetcode.ds1;

class ReverseWordsInStringIII {
    public static void main(String[] args) {
        ReverseWordsInStringIII obj = new ReverseWordsInStringIII();
        String s = "Let's take LeetCode contest";
        System.out.println(obj.reverseWords(s));
    }

    public String reverseWords(String s) {
        StringBuilder resultSB = new StringBuilder();
        String[] sArr = s.split(" ");

        for (int i = 0; i < sArr.length; i++) {
            StringBuilder reverseSB = new StringBuilder();
            reverseSB.append(sArr[i].toString());
            resultSB.append(reverseSB.reverse() + " ");
        }
        return resultSB.toString().trim();
    }
}