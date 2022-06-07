package leetcode.others;

import java.util.Stack;

class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString obj = new RemoveAllAdjacentDuplicatesInString();
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(obj.removeDuplicates(s, k));
    }

    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();

        int counter = 0;
        for (char ch : s.toCharArray()) {
            char temp = '\0';
            if (!stack.isEmpty()) {
                temp = stack.peek();
            }

            if (ch == temp) {
                stack.push(ch);
                counter++;
                if (counter == k) {
                    while (counter > 0) {
                        stack.pop();
                        counter--;
                    }
                }
            } else {
                counter = 1;
                stack.push(ch);
            }
        }

        System.out.println(stack);
        return "";
    }
}