package com.lizp.stack;

import java.util.Stack;

/**
 * ⽤两个栈实现队列
 */
public class Solution5 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public Integer push(Integer item) {
        return stack1.push(item);
    }

    public Integer pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException();
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
