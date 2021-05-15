package com.lizp.list;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + "\n" + (next != null ? next.toString() : "");
    }
}
