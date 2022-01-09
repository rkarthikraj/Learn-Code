package leetcode.biweekly.contest69;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaximumTwinSumLinkedList {
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

    public int twinSum(Node head) {
        if (head == null) {
            return 0;
        }
        Node currentNode = head;
        List<Integer> list = new LinkedList<>();
        int arraySize = 0;
        while (currentNode != null) {
            list.add(currentNode.data);
            currentNode = currentNode.next;
        }

        int left = 0;
        int right = list.size() - 1;
        int result = Integer.MIN_VALUE;
        while (left < right) {
            int sum = list.get(left++) + list.get(right--);
            result = Math.max(sum, result);
        }

        return result;
    }

    public int twinSumArr(Node head) {
        if (head == null) {
            return 0;
        }
        Node currentNode = head;
        int arraySize = 0;
        int[] nodeArr = new int[100001];
        while (currentNode != null) {
            nodeArr[arraySize++] = currentNode.data;
            currentNode = currentNode.next;
        }

        int[] newArray = Arrays.copyOf(nodeArr, arraySize);
        System.out.println(Arrays.toString(newArray));

        int left = 0;
        int right = newArray.length - 1;
        int result = Integer.MIN_VALUE;

        while (left < right) {
            int sum = newArray[left++] + newArray[right--];
            result = Math.max(sum, result);
        }

        return result;
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

    public static void main(String[] args) {
        MaximumTwinSumLinkedList objList = new MaximumTwinSumLinkedList();
        objList.addLast(5);
        objList.addLast(4);
        objList.addLast(2);
        objList.addLast(1);

        objList.printList();
        System.out.println(objList.twinSumArr(objList.head));
    }
}
