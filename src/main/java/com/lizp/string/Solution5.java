package com.lizp.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 * <p>
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 */
public class Solution5 {
    public static int getLongestPalindrome(String A, int n) {
        //dp存的是i到j位的是否是回文串
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

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        //dp存的是i到j位的最长回文串
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static int getLongestPalindrome2(String s) {
        int max = 0;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int[] arr = PalindromeHelper(s, i, i);
            if (arr[1] - arr[0] + 1 > max) {
                max = arr[1] - arr[0] + 1;
                begin = arr[0];
                end = arr[1] + 1;
            }
            //max = Math.max(max, arr[1] - arr[0] + 1);
            arr = PalindromeHelper(s, i, i + 1);
            //max = Math.max(max, arr[1] - arr[0] + 1);
            if (arr[1] - arr[0] + 1 > max) {
                max = arr[1] - arr[0] + 1;
                begin = arr[0];
                end = arr[1] + 1;
            }
        }
        System.err.println(s.substring(begin, end));
        return max;
    }

    //往2边移动
    public static int[] PalindromeHelper(String s, int l, int r) {
        int[] arr = new int[2];
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            arr[0] = l;
            arr[1] = r;
            l--;
            r++;
        }
        return arr;
    }

    /**
     * 构造最长回文串
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int size = s.length();
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (set.contains(s.charAt(i))) {
                count++;
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        return set.isEmpty() ? 2 * count : 2 * count + 1;
    }

    /**
     * 判断是否是回文串
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        getLongestPalindrome("11111", 5);
        getLongestPalindrome2("a123321b");
    }
}
