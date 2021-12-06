package alogs.stackqueue;

import java.io.IOException;
import java.util.Stack;

/*
Implemented queue using stack
 */
public class QueueUsingStack {
    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();

    public void enQueue(int input) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(input);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public static int deQueue() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(0);
        }
        int queueOutput = s1.peek();
        s1.pop();
        return queueOutput;
    }

    public static void main(String args[]) throws IOException {
        QueueUsingStack objQueue = new QueueUsingStack();

        objQueue.enQueue(1);
        objQueue.enQueue(2);
        objQueue.enQueue(3);

        System.out.println(objQueue.deQueue());
        System.out.println(objQueue.deQueue());
        System.out.println(objQueue.deQueue());
    }
}
