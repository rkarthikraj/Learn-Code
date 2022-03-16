package leetcode.others;

import java.util.Stack;

class ValidateStackSequences {
    public static void main(String[] args) {
        ValidateStackSequences obj = new ValidateStackSequences();
        int[] pushed = {1, 2, 3, 4, 5};
        //int[] popped = {4, 5, 3, 2, 1};
        int[] popped = {4, 3, 5, 1, 2};
        System.out.println(obj.validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0; // Push Counter
        int j = 0; // Pop Counter
        int length = pushed.length;

        while (i < length && j < length) {
            if (!stack.isEmpty()) {
                if (stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                } else {
                    stack.push(pushed[i]);
                    i++;
                }
            } else {
                stack.push(pushed[i]);
                i++;
            }
        }

        System.out.println("Stack Before Removal: " + stack);
        System.out.println("I: " + i + ", J: " + j);
        for (int k = j; k < length; k++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == popped[k]) {
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        System.out.println("Stack After Removal: " + stack);

        return stack.isEmpty() ? true : false;
    }
}