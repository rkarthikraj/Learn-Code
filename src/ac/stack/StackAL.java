package ac.stack;

import java.util.ArrayList;

public class StackAL {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        Stack objStack = new Stack();
        objStack.push(1);
        objStack.push(2);
        objStack.push(3);
        objStack.push(4);
        objStack.push(5);

        while (!objStack.isEmpty()) {
            System.out.println(objStack.peek());
            objStack.pop();
        }
    }
}
