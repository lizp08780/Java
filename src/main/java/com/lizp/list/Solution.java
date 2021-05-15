package com.lizp.list;

/**
 * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
 */
public class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode re = new ListNode(-1);
        ListNode pre = re;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    pre.next = l1;
                    pre = pre.next;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    pre = pre.next;
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                pre.next = l1;
                break;
            } else {
                pre.next = l2;
                break;
            }
        }
        return re.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        System.out.println(mergeTwoLists(l1, l2));
    }
}
