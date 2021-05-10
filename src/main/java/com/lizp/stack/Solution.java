package com.lizp.stack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Solution {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        data.push(node);
        if (min.isEmpty() || node < min.peek()) {
            min.push(node);
        }
    }

    public void pop() {
        int item = data.pop();
        if (item == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
