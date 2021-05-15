package com.lizp.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Solution4 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        int num = s.length();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < num; i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                char temp = stack.peek();
                if (temp == map.getOrDefault(s.charAt(i), '#')) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }

    public static int search(int[] nums, int target) {
        // write code here
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right + left) >> 1;
            if (target == nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (target == nums[left]) {
            return left;
        }
        return -1;
    }


    public static void main(String[] args) {

        System.out.println(search(new int[]{1, 2, 4, 4, 5}, 4));
        merge(new int[]{
                1, 0
        }, 1, new int[]{2}, 1);
    }

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), -1);
            } else {
                map.put(str.charAt(i), i);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) >= 0) {
                return map.get(str.charAt(i));
            }
        }
        return -1;
    }

    public static void merge(int A[], int m, int B[], int n) {
        if (n < 1) {
            return;
        }
        int j = m - 1, k = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (j >= 0 && k >= 0 && A[j] >= B[k]) {
                A[i] = A[j];
                j--;
            } else if (k >= 0) {
                A[i] = B[k];
                k--;
            }
        }
    }
}
