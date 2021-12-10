package ac.linkedlist;

public class LinkedList {
    Node head;
    private int size;

    LinkedList(){
        this.size = 0;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // Add - First, Last
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
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

    // Delete - First, Last
    public void deleteFirst() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        size--;
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        size--;
        if (head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    public void printList() {
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

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        LinkedList objList = new LinkedList();
        objList.addFirst("a");
        objList.addFirst("is");
        objList.printList();

        objList.addLast("list");
        objList.printList();

        objList.addFirst("this");
        objList.printList();

        objList.deleteFirst();
        objList.printList();

        objList.deleteLast();
        objList.printList();

        System.out.println(objList.size);
        objList.addFirst("this");
        objList.printList();
        System.out.println(objList.size);

        objList.addLast("list");
        objList.printList();
        System.out.println(objList.size);
    }
}
