package a1;

public class StringPermutation {
    public static void main(String[] args) {
        StringPermutation obj = new StringPermutation();
        String s = "abc";
        obj.permute(s, "");
    }

    public void permute(String s, String answer) {
        if (s.isEmpty()) {
            System.out.println(answer);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String leftSubstr = s.substring(0, i);
            String rightSubstr = s.substring(i + 1);
            String remainingWord = leftSubstr + rightSubstr;
            // System.out.println("Current Char: " + ch + ", i: " + i + ", Left: " + leftSubstr + "\tRight: " + rightSubstr + ", Remaining Word: " + remainingWord);
            permute(remainingWord, answer + ch);
        }
    }
}
