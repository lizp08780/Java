package com.lizp.other;

/**
 * 53. 最大子序和
 */
public class Solution10 {

    public static void main(String[] args) {
        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
            System.err.println(pre + "==" + maxAns);
        }
        return maxAns;
    }
}
