package a1;


public class SlidingWindowTest {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        int s1LengthWS = s1.length();
        int s2Length = s2.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s2Length; i++) {
            int position = i + s1LengthWS;
            if (position < s2Length) {
                sb.append(s2.charAt(i + s1LengthWS));
                System.out.println(sb.toString());
            }
        }
    }
}
