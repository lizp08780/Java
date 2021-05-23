package com.lizp.list;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {
    /**
     * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(-1);
        ListNode pre = result;
        List<Object[]> list = new ArrayList<>();
        int i = 0;
        while (head != null) {
            boolean isDel = false;
            if (i > 0) {
                ListNode last = (ListNode) list.get(i - 1)[0];
                if (head.val == last.val) {
                    list.get(i - 1)[1] = true;
                    isDel = true;
                }
            }
            list.add(new Object[]{head, isDel});
            i++;
            head = head.next;
        }
        for (Object[] a : list) {
            if (!(Boolean) a[1]) {
                pre.next = (ListNode) a[0];
                pre = (ListNode) a[0];
                pre.next = null;
            }
        }
        return result.next;
    }

    /**
     * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode pre = result;
        while (head != null) {
            if (head.val == pre.val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        System.err.println(result);
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(7, node7);
        ListNode node5 = new ListNode(7, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(1, node2);
        deleteDuplicates2(node1);
    }
}
