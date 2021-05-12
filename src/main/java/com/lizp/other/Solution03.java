package com.lizp.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
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

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public int[] twoSum3(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        Arrays.sort(numbers);
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;

    }
}
