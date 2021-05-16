package com.lizp.array;

/**
 * 53. 最大子序和
 */
public class Solution10 {

    public static void main(String[] args) {
        maxsumofSubarray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
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

    /**
     * 假设我们已经知道了以第i-1个数结尾的连续子数组的最大和f(i-1)，
     * 显然以第i个数结尾的连续子数组的最大和的可能取值要么为f(i-1)+nums[i]，要么就nums[i]单独成一段，也就是nums[i]
     *
     * @param arr
     * @return
     */
    public static int maxsumofSubarray(int[] arr) {
        // write code here
        int size = arr.length;
        int[] dp = new int[size];
        //以0结尾
        dp[0] = arr[0];
        int re = dp[0];
        for (int i = 1; i < size; i++) {
            //以i结尾
            dp[i] = Math.max(dp[i - 1], 0) + arr[i];
            re = Math.max(re, dp[i]);
        }
        return re;
    }
}
