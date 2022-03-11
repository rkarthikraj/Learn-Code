package leetcode.others;

class RotateList {
    ListNode head;

    class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
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
            System.out.print(currentNode.val + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }

    public ListNode rotateRight(ListNode head, int k) {
        int listSize = 0;
        ListNode result = null;
        ListNode node = head;
        while (node != null) {
            listSize++;
            node = node.next;
        }

        if (listSize == 0 || listSize == 1)
            return head;

        if (k >= listSize)
            k = k % listSize;

        if(k == 0) {
            return head;
        }

        ListNode remainingList = head;
        int toTraverse = listSize - k;
        while (toTraverse > 0) {
            remainingList = remainingList.next;
            toTraverse--;
        }

        result = remainingList;
        while (remainingList.next != null) {
            remainingList = remainingList.next;
        }

        int toTraverseFirstPart = listSize - k - 1;
        ListNode firstPart = head;
        while(toTraverseFirstPart > 0) {
            head = head.next;
            toTraverseFirstPart--;
        }
        head.next = null;

        remainingList.next = firstPart;
        return result;
    }

    public static void main(String[] args) {
        RotateList objList1 = new RotateList();
        objList1.addLast(1);
        objList1.addLast(2);
        objList1.addLast(3);
        objList1.addLast(4);
        objList1.addLast(5);
        objList1.printList(objList1.rotateRight(objList1.head, 2));

        RotateList objList2 = new RotateList();
        objList2.addLast(0);
        objList2.addLast(1);
        objList2.addLast(2);
        objList2.printList(objList2.rotateRight(objList2.head, 4));

        RotateList objList3 = new RotateList();
        objList3.addLast(1);
        objList3.addLast(2);
        objList3.printList(objList3.rotateRight(objList3.head, 1));

        RotateList objList4 = new RotateList();
        objList4.addLast(1);
        objList4.addLast(2);
        objList4.printList(objList3.rotateRight(objList4.head, 2));
    }
}