package leetcode.msiq;

import java.util.Stack;

class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();
        // String parantheses = "((((([[][]][])))))";
        String parantheses = ")";
        System.out.println(obj.isValid(parantheses));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    if (isValidParantheses(stack.pop(), c)) {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isOpeningParantheces(char c) {
        if (c == '(')
            return true;
        if (c == '[')
            return true;
        if (c == '{')
            return true;

        return false;
    }

    public boolean isValidParantheses(char c1, char c2) {
        if (c1 == '(' && c2 == ')') {
            return true;
        } else if (c1 == '[' && c2 == ']') {
            return true;
        } else if (c1 == '{' && c2 == '}') {
            return true;
        }

        return false;
    }
}