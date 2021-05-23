package com.lizp.stack;

import java.util.Stack;

public class Solution6 {
    /**
     * 栈的压⼊,弹出序列
     * 12345
     * 45321
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (popA == null || popA.length < 1 || pushA == null || pushA.length < 1) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
