package com.lizp.list;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        int count = (list.size() - 1) / 2;
        for (int i = 0; i < count; i++) {
            list.get(i).next = list.get(list.size() - i - 1);
            list.get(list.size() - i - 1).next = list.get(i + 1);
        }
        //否则成环了
        list.get(list.size() % 2 == 1 ? count : count + 1).next = null;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.err.println(node1);
        reorderList(node1);
        System.err.println(node1);
    }
}
