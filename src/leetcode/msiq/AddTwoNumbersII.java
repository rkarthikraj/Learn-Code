package leetcode.msiq;

class AddTwoNumbersII {
    ListNode head;

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Add - First, Last
    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
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

    public void printList() {
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

    public void printResultList(ListNode head) {
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

    public static void main(String[] args) {
        AddTwoNumbersII l1 = new AddTwoNumbersII();
//        l1.addLast(9);
//        l1.addLast(1);
//        l1.addLast(6);

                l1.addLast(7);
                l1.addLast(2);
                l1.addLast(4);
                l1.addLast(3);
        l1.printList();

        AddTwoNumbersII l2 = new AddTwoNumbersII();

                l2.addLast(5);
                l2.addLast(6);
                l2.addLast(4);

        l2.printList();

        AddTwoNumbersII obj = new AddTwoNumbersII();
        ListNode result = obj.addTwoNumbers(l1.head, l2.head);
        obj.printResultList(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        AddTwoNumbersII result = new AddTwoNumbersII();

        int l1Length = 0;
        int l2Length = 0;

        //------To Find Length------
        ListNode l1Node = l1;
        while (l1Node != null) {
            l1Length++;
            l1Node = l1Node.next;
        }

        ListNode l2Node = l2;
        while (l2Node != null) {
            l2Length++;
            l2Node = l2Node.next;
        }
        //System.out.println("Length L1: " + l1Length + ", Length L2: " + l2Length);
        //--------------------------

        int carry = 0;
        while ((l1Length - 1) >= 0 && (l2Length - 1) >= 0) {
            int v1 = 0;
            int v2 = 0;

            ListNode tempL1 = l1;
            int l1Traverse = 0;

            while (tempL1 != null) {
                if (l1Traverse == (l1Length - 1)) {
                    v1 = tempL1.val;
                    // System.out.print("L1 Val: " + tempL1.val);
                }
                tempL1 = tempL1.next;
                l1Traverse++;
            }

            ListNode tempL2 = l2;
            int l2Traverse = 0;

            while (tempL2 != null) {
                if (l2Traverse == (l2Length - 1)) {
                    v2 = tempL2.val;
                    // System.out.print("\tL2 Val: " + tempL2.val);
                }
                tempL2 = tempL2.next;
                l2Traverse++;
            }

            int sum = v1 + v2 + carry;
            if(sum >= 10) {
                carry = sum / 10;
                sum = sum%10;
            } else {
                carry = 0;
            }
            result.addFirst(sum);

            System.out.println();

            l1Length--;
            l2Length--;
        }

        //System.out.println("Length L1: " + l1Length + ", Length L2: " + l2Length);

        if(l1Length != 0) {
            int sum = 0;
            // ListNode tempL1 = l1;

            while(l1Length > 0) {
                ListNode tempL1 = l1;
                int tempLen1 = 0;
                while (tempL1 != null) {
                    if (tempLen1 == (l1Length - 1)) {
                        sum = tempL1.val + carry;
                    }
                    tempL1 = tempL1.next;
                    tempLen1++;
                }

                if (sum >= 10) {
                    carry = sum / 10;
                    sum = sum % 10;
                }
                result.addFirst(sum);
                l1Length--;
            }

//            while (tempL1 != null) {
//                if(l1Length > 0) {
//                    sum = tempL1.val + carry;
//                }
//                tempL1 = tempL1.next;
//                l1Length--;
//            }
//            if (sum >= 10) {
//                carry = sum / 10;
//                sum = sum % 10;
//            }
//            result.addFirst(sum);
        } else if(l2Length != 0) {
            int sum = 0;
            while(l2Length > 0) {
                ListNode tempL2 = l2;
                int tempLen2 = 0;
                while (tempL2 != null) {
                    if (tempLen2 == (l2Length - 1)) {
                        sum = tempL2.val + carry;
                    }
                    tempL2 = tempL2.next;
                    tempLen2++;
                }

                if (sum >= 10) {
                    carry = sum / 10;
                    sum = sum % 10;
                }
                result.addFirst(sum);
                l2Length--;
            }
        }

        if(carry != 0) {
            result.addFirst(carry);
        }
        return result.head;
    }
}