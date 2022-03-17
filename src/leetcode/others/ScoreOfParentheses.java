package leetcode.others;

import java.util.Stack;

class ScoreOfParentheses {
    public static void main(String[] args) {
        ScoreOfParentheses obj = new ScoreOfParentheses();
        String str1 = "()()";
        String str2 = "(())";
        String str3 = "()";
        String str4 = "(()(()))";
        System.out.println(obj.scoreOfParentheses(str1));
        System.out.println(obj.scoreOfParentheses(str2));
        System.out.println(obj.scoreOfParentheses(str3));
        System.out.println(obj.scoreOfParentheses(str4));
    }

    public int scoreOfParentheses(String s) {
        int score = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(score);
                score = 0;
            } else if (ch == ')') {
                score = stack.pop() + Math.max(2 * score, 1);
            }
        }

        return score;
    }
}