package leetcode.others;

import java.util.HashMap;
import java.util.Map;

class RemoveDuplicatesFromSortedListII {
    ListNode head;

    class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add
    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
    }

    public void printList(ListNode head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> hm = new HashMap<>();
        ListNode node = head;
        while (node != null) {
            hm.put(node.data, hm.getOrDefault(node.data, 0) + 1);
            node = node.next;
        }

        node = head;
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        while (node != null) {
            if (hm.get(node.data) == 1) {
                dummy.next = new ListNode(node.data);
                dummy = dummy.next;
            }
            node = node.next;
        }

        //        Use treemap
        //        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
        //            if(entry.getValue() == 1) {
        //                dummy.next = new ListNode(entry.getKey());
        //                dummy = dummy.next;
        //            }
        //        }


        return result.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII objList = new RemoveDuplicatesFromSortedListII();
        objList.addLast(1);
        objList.addLast(1);
        objList.addLast(1);
        objList.addLast(2);
        objList.addLast(3);
        objList.addLast(3);
        objList.addLast(4);

        objList.printList(objList.head);
        objList.printList(objList.deleteDuplicates(objList.head));
    }
}