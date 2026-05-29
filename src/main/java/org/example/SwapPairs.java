package org.example;

public class SwapPairs {
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


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode remainingList = swapPairs(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = remainingList;
        return newHead;
    }

    public static void main(String[] args) {
        SwapPairs pairs = new SwapPairs();
        ListNode listNode = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));
        ListNode head = pairs.swapPairs(listNode);

    }

}
