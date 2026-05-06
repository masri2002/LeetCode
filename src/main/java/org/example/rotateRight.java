package org.example;

public class rotateRight {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode check = head;
        int n = 0;
        while (check != null) {
            n++;
            check = check.next;
        }
        for (int i = 0; i < k % n; i++) {

            ListNode temp = head;
            while (temp != null) {
                if (temp.next.next == null) {
                    ListNode next = temp.next;
                    temp.next = null;
                    next.next = head;
                    head = next;
                }
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        rotateRight l = new rotateRight();
        ListNode vode = l.rotateRight(one, 2);
        while (vode != null) {
            System.out.println(vode.val);
            vode = vode.next;
        }
    }

}
