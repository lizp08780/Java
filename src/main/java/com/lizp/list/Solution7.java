package com.lizp.list;

/**
 * 编号为 11 到 nn 的 nn 个人围成一圈。从编号为 11 的人开始报数，报到 mm 的人离开。
 * 下一个人继续从 11 开始报数。
 * n-1n−1 轮结束以后，只剩下一个人，问最后留下的这个人编号是多少？
 */
public class Solution7 {
    public int ysf(int n, int m) {
        ListNode next = null;
        ListNode tail = null;
        for (int i = n; i > 0; i--) {
            next = new ListNode(i, next);
            if (i == n) {
                tail = next;
            }
        }
        tail.next = next;
        int index = 0;
        ListNode pre = tail;
        while (next != next.next) {
            index++;
            if (index == m) {
                pre.next = next.next;
                index = 0;
            } else {
                pre = pre.next;
            }
            next = next.next;
        }
        return next.val;
    }
}
