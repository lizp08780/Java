package com.lizp.string;

/**
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 * <p>
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 */
public class Solution5 {
    public static int getLongestPalindrome(String A, int n) {
        // write code here
        boolean[][] dp = new boolean[n][n];
        int re = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i + 1 < n && A.charAt(i) == A.charAt(i + 1)) {
                dp[i][i + 1] = true;
                re = 2;
            }
        }

        for (int L = 0; L < n - 2; L++) {
            for (int i = 0; i < n - L - 2; i++) {
                int j = i + 2 + L;
                if (A.charAt(i) == A.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    re = 3 + L;
                }

            }
        }
        return re;
    }

    public static void main(String[] args) {
        getLongestPalindrome("11111", 5);
    }
}
