package leetcode.msiq;

class RegularExpressions {
    public static void main(String[] args) {
        RegularExpressions solution = new RegularExpressions();
        System.out.println("true  -- " + solution.isMatch("aa", "a*"));
        System.out.println("true  -- " + solution.isMatch("aab", "c*a*b"));
        System.out.println("false -- " + solution.isMatch("mississippi", "mis*is*p*."));
        System.out.println("false -- " + solution.isMatch("ab", ".*c"));
        System.out.println("false -- " + solution.isMatch("aaa", "aaaa"));
    }

    public boolean isMatch(String s, String p) {
        return match(0, 0, s, p);
    }

    public boolean match(int stringPtr, int patternPtr, String s, String p) {
        boolean isMatch = false;

        if (patternPtr == p.length())
            return stringPtr == s.length();

        boolean firstMatch = stringPtr < s.length() && (s.charAt(stringPtr) == p.charAt(patternPtr) || p.charAt(patternPtr) == '.');

        if ((patternPtr + 1) < p.length() && p.charAt(patternPtr + 1) == '*') {
            //aaaaaaa
            //a*b
            isMatch = (firstMatch && match(stringPtr + 1, patternPtr, s, p)) || match(stringPtr, patternPtr + 2, s, p);
        } else {
            //pattern + 1 != *
            //aa
            //ab
            isMatch = firstMatch && match(stringPtr + 1, patternPtr + 1, s, p);
        }

        return isMatch;
    }
}