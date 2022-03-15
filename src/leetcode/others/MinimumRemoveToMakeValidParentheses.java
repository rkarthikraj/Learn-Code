package leetcode.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        MinimumRemoveToMakeValidParentheses obj = new MinimumRemoveToMakeValidParentheses();
        String str1 = "lee(t(c)o)de)";
        System.out.println(obj.minRemoveToMakeValid(str1));

        String str2 = "))((";
        System.out.println(obj.minRemoveToMakeValid(str2));

        String str3 = "a)b(c)d";
        System.out.println(obj.minRemoveToMakeValid(str3));

        String str4 = "(a(b(c)d)";
        System.out.println(obj.minRemoveToMakeValid(str4));
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    toRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            toRemove.add(stack.pop());
        }

        System.out.println("Input: " + s + "Remove List: " + toRemove + "Stack: " + stack);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(!toRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}