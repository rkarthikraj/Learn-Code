package ac.linkedlist;

/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
Memory Usage: 37.2 MB, less than 36.53% of Java online submissions for Remove Nth Node From End of List.
 */
public class DeleteNthFromEnd {
    Node head;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public Node removeNthFromEnd(int n) {
        if (head == null) {
            return null;
        }

        Node current = head;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }

        if (n == size) {
            System.out.println("Size = n: " + head.next.data);
            return head.next;
        }

        int indexToSearch = size - n - 1;
        Node prev = head;
        int i = 0;
        while (i < indexToSearch) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return head;
    }

    public void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DeleteNthFromEnd objList = new DeleteNthFromEnd();
        objList.addFirst("list");
        objList.addFirst("a");
        objList.addFirst("is");
        objList.addFirst("this");

        //objList.removeNthFromEnd(4);
        objList.printList(objList.removeNthFromEnd(4));
    }
}
