package leetcode.msiq;

class LongestPalindromicSubstring {
    int resultStart;
    int resultLength;

    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        String s1 = "babad";
        String s2 = "cbbd";
        // System.out.println(obj.longestPalindrome(s1));
        System.out.println(obj.longestPalindrome(s2));
    }

    public String longestPalindrome(String s) {
        int strLength = s.length();
        if (strLength < 2) {
            return s;
        }
        for (int start = 0; start < strLength; start++) {
            expandRange(s, start, start, "ODD");
            expandRange(s, start, start + 1, "EVEN");
        }

        return s.substring(resultStart, resultStart + resultLength);
    }

    private void expandRange(String str, int begin, int end, String type) {
        System.out.println("Type: " + type + "\tBegin: " + begin + ", End: " + end + ", String: " + str + ", CharAt(Begin): " + str.charAt(begin) + ", CharAt(End): " + str.charAt(end));
        //        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
        //            begin--;
        //            end++;
        //        }
        //        if (resultLength < end - begin - 1) {
        //            resultStart = begin + 1;
        //            resultLength = end - begin - 1;
        //        }
    }

    /*
    public String longestPalindrome(String s) {
        result = "";
        for (int i = 0; i < s.length(); i++) {
            slide(i, s);
        }
        return result;
    }

    public void slide(int start, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            for (int j = start; j <= i; j++) {
                sb.append(s.charAt(j));
            }
            String value = sb.toString();
            int resultLength = result.length();
            int valueLength = value.length();
            if(valueLength > resultLength) {
                if (isPalindrome(value)) {
                    if (valueLength >= resultLength) {
                        result = value;
                    }
                }
            }
            sb.setLength(0);
        }
    }

    public boolean isPalindrome(String value) {
        String reverseValue = new StringBuilder(value).reverse().toString();
        if (value.equals(reverseValue)) {
            return true;
        } else {
            return false;
        }
    }
     */
}