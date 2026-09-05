package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prevNode = head;
        ListNode currNode = head.next;
        List<Integer> list = new ArrayList<>();
        int i = 2;
        while (currNode.next != null) {
            if (prevNode.val > currNode.val && currNode.val < currNode.next.val) {
                list.add(i);
            }
            if (prevNode.val < currNode.val && currNode.val > currNode.next.val) {
                list.add(i);
            }
            prevNode = currNode;
            currNode = currNode.next;
            i++;
        }
        Collections.sort(list);
        Collections.sort(list);

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;

        for (int i1 = 1; i1 < list.size(); i1++) {
            int distance = list.get(i) - list.get(i1 - 1);

            minDistance = Math.min(minDistance, distance);
        }
        if (list.size() >= 2) {
            maxDistance = list.getLast() - list.getFirst();
        }

        if (maxDistance == Integer.MIN_VALUE && minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        return new int[]{minDistance, maxDistance};

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);

        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(1);
        listNode.next.next.next.next.next.next = new ListNode(2);
        NodesBetweenCriticalPoints test = new NodesBetweenCriticalPoints();
        int[] result = test.nodesBetweenCriticalPoints(listNode);
        System.out.println(Arrays.toString(result));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[] nodesBetweenCriticalPointsOpt(ListNode head) {

        int prev=head.val;
        int curr,next;
        ListNode temp=head.next;

        int mindis;
        int maxdis;

        int firstidx=0,curridx=0,previdx=0;



        while(temp.next!=null){
            curr=temp.val;
            next=temp.next.val;
            temp=temp.next;
            if(curr<prev && curr<next || curr>prev && curr>next ) {
                curridx=1;
                firstidx=1;
                prev=curr;
                break;
            }
            prev=curr;
        }

        if(firstidx==0) return new int[]{-1,-1};

        while(temp.next!=null){
            curr=temp.val;
            next=temp.next.val;
            temp=temp.next;
            curridx++;
            if(curr<prev && curr<next || curr>prev && curr>next ) {
                previdx=curridx;
                prev=curr;
                break;
            }
            prev=curr;
        }

        if(previdx==0) return new int[]{-1,-1};

        mindis=maxdis=curridx-firstidx;

        while(temp.next!=null){
            curr=temp.val;
            next=temp.next.val;
            temp=temp.next;
            curridx++;
            if(curr<prev && curr<next || curr>prev && curr>next ) {
                maxdis=curridx-firstidx;
                if((curridx-previdx)<mindis) mindis=curridx-previdx;
                previdx=curridx;

            }
            prev=curr;
        }

        return new int[]{mindis,maxdis};

    }
}
