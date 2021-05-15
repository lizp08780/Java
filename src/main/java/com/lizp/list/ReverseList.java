package com.lizp.list;

public class ReverseList {
    public ListNode reverse(ListNode head) {
        ListNode result = new ListNode(-1);
        while (head != null) {
            //保存下一node
            ListNode temp = head.next;
            //当前node指向最前面
            head.next = result.next;
            result.next = head;
            //当前node移到下以为
            head = temp;
        }
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
