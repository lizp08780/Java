package com.lizp.array;

/**
 * 4. 寻找两个正序数组的中位数
 */
public class Solution5 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        int l1 = nums1 == null ? 0 : nums1.length;
        int l2 = nums2 == null ? 0 : nums2.length;
        int i = 0;
        int j = 0;
        int count = 0;
        int[] re = new int[l1 + l2];
        while (true) {
            if (i < l1 && j < l2) {
                if (nums1[i] <= nums2[j]) {
                    re[count++] = nums1[i];
                    i++;
                } else {
                    re[count++] = nums2[j];
                    j++;
                }
            } else if (i < l1) {
                re[count++] = nums1[i];
                i++;
            } else {
                re[count++] = nums2[j];
                j++;
            }
            if (count - 1 == (l1 + l2) / 2) {
                if ((l1 + l2) % 2 == 1) {
                    return re[count - 1];
                } else {
                    return (re[count - 1] + re[count - 2]) / 2.0;
                }
            }
        }
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{
                1, 3
        }, new int[]{
                2, 4
        });
    }
}
