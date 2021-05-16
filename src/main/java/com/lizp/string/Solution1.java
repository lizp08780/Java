package com.lizp.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 */
public class Solution1 {
    public static String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        int n = s.length();
        if (n <= numRows || numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int sel = 0;
        int add = 1;
        for (int i = 0; i < n; i++) {
            list.get(sel).append(s.charAt(i));
            if (sel == 0) {
                add = 1;
            } else if (sel == numRows - 1) {
                add = -1;
            }
            sel = sel + add;
        }

        StringBuilder sb = new StringBuilder();
        list.forEach(s1 -> sb.append(s1));
        return sb.toString();
    }

    public static void main(String[] args) {
        convert("1234567890", 1);
    }
}
