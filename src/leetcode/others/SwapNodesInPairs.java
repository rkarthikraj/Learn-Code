package leetcode.others;

class SwapNodesInPairs {
    ListNode head;

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

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
            System.out.print(currentNode.val + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }


    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        printList(dummy);

        ListNode prevNode = dummy;
        printList(prevNode);

        while(head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head = firstNode.next;
        }

        printList(dummy.next);
        return head;
    }

    public static void main(String[] args) {
        SwapNodesInPairs obj = new SwapNodesInPairs();
        obj.addLast(1);
        obj.addLast(2);
        obj.addLast(3);
        obj.addLast(4);
        obj.addLast(5);

        //obj.printList();
        obj.swapPairs(obj.head);
    }
}