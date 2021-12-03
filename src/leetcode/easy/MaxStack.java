package leetcode.easy;

/*
https://leetcode.com/problems/max-stack/
Runtime: 44 ms, faster than 5.63% of Java online submissions for Max Stack.
Memory Usage: 51.7 MB, less than 26.63% of Java online submissions for Max Stack.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxStack {
    Stack<Integer> stack = null;
    Map<Integer, Integer> hm = new HashMap<>();

    public MaxStack() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < stack.size(); i++) {
            max = Math.max(max, stack.get(i));
        }
        return max;
    }

    public int popMax() {
        int max = Integer.MIN_VALUE;
        int updatedMax = Integer.MIN_VALUE;
        int i = 0;
        for (i = 0; i < stack.size(); ++i) {
            max = Math.max(max, stack.get(i));
            if (max != updatedMax || (stack.get(i) == updatedMax && hm.get(max) != i)) {
                hm.put(max, i);
                updatedMax = max;
            }
        }

        int index = hm.get(max);

        System.out.println("HM -> " + hm);
        System.out.println("index -> " + index);

        stack.remove(index);
        return max;
    }

    public static void main(String[] args) {
        MaxStack obj = null;

        String[] instructions = {"MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"};
        int[][] values = {{}, {5}, {1}, {5}, {}, {}, {}, {}, {}, {}};

        //String[] instructions = {"MaxStack", "push", "push", "popMax", "peekMax"};
        //int[][] values = {{}, {5}, {1}, {}, {}};

        for (int i = 0; i < values.length; i++) {
            String instruction = instructions[i];

            switch (instruction) {
                case "MaxStack":
                    obj = new MaxStack();
                    break;
                case "push":
                    obj.push(values[i][0]);
                    System.out.println("push -> " + obj.stack);
                    break;
                case "top":
                    System.out.println("top -> " + obj.top());
                    System.out.println("stack -> " + obj.stack);
                    break;
                case "popMax":
                    System.out.println("popMax -> " + obj.popMax());
                    System.out.println("stack -> " + obj.stack);
                    break;
                case "peekMax":
                    System.out.println("peekMax -> " + obj.peekMax());
                    System.out.println("stack -> " + obj.stack);
                    break;
                case "pop":
                    System.out.println("pop -> " + obj.pop());
                    break;
            }
        }
    }
}
