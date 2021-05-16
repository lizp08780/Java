package com.lizp.string;

/**
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 */
public class Solution {
    public static String solve(String s, String t) {
        // write code here
        int sl = s.length();
        int tl = t.length();
        int max = Math.max(sl, tl);
        char[] re = new char[max];
        int last = 0;
        for (int i = 0; i < max; i++) {
            int sum = last + (i < sl ? s.charAt(sl - i - 1) : '0') - 48 +
                    (i < tl ? t.charAt(tl - i - 1) : '0') - 48;
            re[max - 1 - i] = (char) (sum % 10 + 48);
            last = sum / 10;
        }
        return (last > 0 ? last + "" : "") + String.valueOf(re);
    }

    public static void main(String[] args) {
        System.out.println(solve("9", "99999999999999999999999999999999999999999999999999999999999994"));
    }
}
