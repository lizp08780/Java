package com.lizp.list;

/**
 * 反转链表
 */
public class ReverseList {
    public static ListNode reverse(ListNode head) {
        ListNode result = new ListNode(-1);
        while (head != null) {
            //保存下一node
            ListNode temp = head.next;
            //当前node指向最前面
            head.next = result.next;
            result.next = head;
            //当前node移到下1位
            head = temp;
        }
        return result.next;
    }

    public static ListNode reverse2(ListNode head) {
        ListNode result = null;
        while (head != null) {
            //保存下一node
            ListNode temp = head.next;
            //当前node指向最前面
            head.next = result;
            result = head;
            //当前node移到下1位
            head = temp;
        }
        return result;
    }

    public static ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode pNext = tail.next;
        ListNode p = head;
        while (pNext != tail) {
            ListNode temp = p.next;
            p.next = pNext;
            pNext = p;
            p = temp;
        }
        return new ListNode[]{tail, head};
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode hair = new ListNode(-1);
        hair.next = head;
        //pre 一组的头节点前一个
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            // 移动k位，获取当前组尾节点
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                //不足k长度，中止
                if (tail == null) {
                    return hair.next;
                }
            }
            //记录下一组的头节点
            ListNode temp = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = temp;
            //下一次循环
            pre = tail;
            head = pre.next;
        }
        return hair;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        // System.err.println(myReverse(node1, node3)[1]);
        // System.err.println(reverse3(node1, 3));
        System.err.println(reverseKGroup(node1, 3));
    }
}
