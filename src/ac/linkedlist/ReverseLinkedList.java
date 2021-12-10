package ac.linkedlist;

public class ReverseLinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add - First, Last
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
    }

    public void reverseLinkedList() {
        if (head == null) {
            return;
        }

        Node previousNode = head;
        Node currentNode = head.next;

        while (currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = previousNode;

            //Update
            previousNode = currentNode;
            currentNode = nextNode;
        }

        head.next = null;
        head = previousNode;
    }

    public void printList() {
        if (head == null || head.next == null) {
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
        ReverseLinkedList objList = new ReverseLinkedList();
        objList.addLast(1);
        objList.addLast(2);
        objList.addLast(3);
        objList.addLast(4);
        objList.printList();

        objList.reverseLinkedList();
        objList.printList();
    }
}
