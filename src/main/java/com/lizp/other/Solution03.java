package com.lizp.other;

public class Solution03 {
    public static void main(final String[] args) {
        Integer x1 = 100, x2 = 100, x3 = 200, x4 = 200;
        System.err.println(x1 == x2);
        System.err.println(x3 == x4);
    }

    public int[] twoSum(final int[] nums, final int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
