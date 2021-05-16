package com.lizp.string;

import java.util.HashSet;
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
}
