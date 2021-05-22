package com.lizp.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int max = 1;
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    break;
                }
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int max = 1;
        int begin = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                begin = Math.max(map.get(s.charAt(i)), begin);
            }
            max = Math.max(max, i - begin + 1);
            map.put(s.charAt(i), i + 1);
        }
        return max;
    }

    /**
     * 最长无重复元素子数组的长度
     *
     * @param arr
     * @return
     */
    public int maxLength(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int size = arr.length;
        int max = 1;
        for (int i = 0; i < size; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < size; j++) {
                if (set.contains(arr[j])) {
                    break;
                } else {
                    set.add(arr[j]);
                }
            }
            max = Math.max(max, set.size());
        }
        return max;
    }
}
