package ac.linkedlist;

/*
https://leetcode.com/problems/palindrome-linked-list/
Runtime: 27 ms, faster than 7.20% of Java online submissions for Palindrome Linked List.
Memory Usage: 122.2 MB, less than 5.72% of Java online submissions for Palindrome Linked List.
 */
public class CheckLinkedListIsPalindrome  {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public boolean isPalindrome() {
        if (head == null) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
        }

        if(sb.toString().equals(sb.reverse().toString())){
            System.out.println(sb.toString());
            return true;
        }

        return false;
    }

    public boolean isPalindromeOptimize() {
        if (head == null) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
        }

        if(sb.toString().equals(sb.reverse().toString())){
            System.out.println(sb.toString());
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        CheckLinkedListIsPalindrome objList = new CheckLinkedListIsPalindrome();
        objList.addFirst(1);
        objList.addFirst(3);
        objList.addFirst(2);
        objList.addFirst(1);

        System.out.println(objList.isPalindrome());
    }
}
