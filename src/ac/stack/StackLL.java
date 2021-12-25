package ac.stack;

public class StackLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static class Stack {
        public static Node head;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }

            return head.data;
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
