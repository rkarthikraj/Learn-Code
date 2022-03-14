package leetcode.others;

import java.util.Arrays;
import java.util.Stack;

class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath obj = new SimplifyPath();
        String absPath = "/a/b/c/.././././//d";
        System.out.println(obj.simplifyPath(absPath));
    }

    public String simplifyPath(String path) {
        String[] splitPath = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String value : splitPath) {
            if (value.equals(".") || value.isEmpty()) {
                continue;
            } else if (value.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(value);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String value : stack) {
            result.append("/");
            result.append(value);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}