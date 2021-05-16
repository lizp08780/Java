package com.lizp.integer;

/**
 * 7. 整数反转
 */
public class Solution {
    public int reverse(int x) {
        int sum = 0;
        while (x != 0) {
            if (sum > Integer.MAX_VALUE / 10 || sum < Integer.MIN_VALUE / 10) {
                return 0;
            }
            sum = 10 * sum + x % 10;
            x = x / 10;
        }
        return sum;
    }
}