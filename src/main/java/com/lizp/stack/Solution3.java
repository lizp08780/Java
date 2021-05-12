package com.lizp.stack;

import java.util.Stack;

public class Solution3 {
    public static void main(String[] args) {
        String nums = "2379180123091";
        char[] arr = nums.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.empty()) {
                stack.push(arr[i]);
            } else {
                char x = stack.peek();
                if ((int) x + (int) arr[i] - 48 * 2 == 10) {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            }
        }
        System.err.println(stack);
    }
}
