package com.lizp.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 */
public class Solution13 {

    public static void main(String[] args) {
        //System.err.println(gcd(5, 3));
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> map = new HashMap();
        for (int a : array) {
            map.put(a, map.getOrDefault(a, 0) + 1);
            if (map.get(a) >= array.length / 2 + array.length % 2) {
                return a;
            }
        }
        return -1;
    }
}
