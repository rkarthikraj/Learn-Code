package leetcode.others;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top = -1;
    public ImplementStackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        top = x;
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        int popElement = -1;
        if(!queue1.isEmpty()) {
            popElement = queue1.peek();
            queue1.remove();
        }

        if (!queue1.isEmpty()) {
            top = queue1.peek();
        }
        // System.out.println(popElement);
        return popElement;
    }

    public int top() {
        // System.out.println(top);
        return top;
    }

    public boolean empty() {
        if (queue1.isEmpty()) {
           return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ImplementStackUsingQueue obj = new ImplementStackUsingQueue();
        String[] operations = {"MyStack", "push", "push", "top", "pop", "empty"};
        //String[] operations2 = {"MyStack", "push", "push", "push", "push", "pop", "top"};
        int[][] values = {{}, {1}, {2}, {}, {}, {}};
        //int[][] values2 = {{}, {1}, {2}, {3}, {4}, {}};

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MyStack":
                    break;
                case "push":
                    obj.push(values[i][0]);
                    break;
                case "top":
                    obj.top();
                    break;
                case "pop":
                    obj.pop();
                    break;
                case "empty":
                    System.out.println(obj.empty());
                    break;
            }
        }
    }
}
