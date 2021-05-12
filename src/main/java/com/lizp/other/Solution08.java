package com.lizp.other;

/**
 * 38. 外观数列
 */
public class Solution08 {
    public static void main(String[] args) {
        countAndSay(10);
    }

    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            s = describe(s);
        }
        return s;
    }

    public static String describe(String s) {
        StringBuffer res = new StringBuffer();
        if (s.length() == 1) {
            res.append('1');
            res.append(s);
        }
        int num = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                num += 1;
                if (i == s.length() - 1) {
                    res.append(num);
                    res.append(s.charAt(i - 1));
                }
            } else {
                res.append(num);
                res.append(s.charAt(i - 1));
                num = 1;
                if (i == s.length() - 1) {
                    res.append(1);
                    res.append(s.charAt(i));
                }
            }
        }
        System.err.println(res);
        return res.toString();
    }
}
