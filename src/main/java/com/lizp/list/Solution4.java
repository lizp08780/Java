package com.lizp.list;

public class Solution4 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode p = head;
        ListNode p2 = head;
        int index = 0;
        while (p != null) {
            index++;
            p = p.next;
            if (index > n + 1) {
                p2 = p2.next;
            }
        }
        if (index > n) {
            p2.next = p2.next.next;
        } else {
            return p2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        removeNthFromEnd(node7, 1);
    }
}
