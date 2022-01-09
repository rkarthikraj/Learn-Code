package leetcode.ds1;

public class RemoveDuplicatesInLinkedList {
    Node head;
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
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

    public Node removeDuplicates(Node head) {
        if(head == null){
            return head;
        }

        Node result = new Node(0);
        result.next = head;

        Node previous = result;
        Node current = head;

        while (current != null) {
            int value = current.data;
            if (current.next != null && value == current.next.data) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }

        System.out.println();
        return result.next;
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

    public void printListNode(Node head) {
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
        RemoveDuplicatesInLinkedList objList = new RemoveDuplicatesInLinkedList();
        objList.addLast(1);
        objList.addLast(1);
        objList.addLast(2);
        objList.addLast(2);
        objList.addLast(3);
        objList.addLast(4);

        objList.printList();
        System.out.println("-----------------------------");
        objList.printListNode(objList.removeDuplicates(objList.head));
    }
}
