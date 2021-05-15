package com.lizp.array;

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * <p>
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 */
public class Solution1 {
    public int findKth(int[] a, int n, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 1; j < n - i; j++) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a[n - k];
    }
}
