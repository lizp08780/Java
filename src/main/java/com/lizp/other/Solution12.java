package com.lizp.other;

/**
 *
 */
public class Solution12 {

    public static void main(String[] args) {
        System.err.println(gcd(5, 3));
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;

            System.err.println(a + "=" + b);
        }
        return a;
    }
}
