package com.lizp.integer;

import java.math.BigDecimal;

public class Solution2 {
    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int fh = 0;
        int size = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (c == '+' || c >= '0' && c <= '9') {
                if (fh == 0) {
                    fh = 1;
                } else {
                    if (c == '+') {
                        break;
                    }
                }
                if (c != '+') {
                    sb.append(s.charAt(i));
                    continue;
                }
            } else if (c == '-') {
                if (fh == 0) {
                    fh = -1;
                } else {
                    break;
                }
            }
            if (fh != 0 && !(c >= '0' && c <= '9') && sb.length() > 0) {
                break;
            } else if (fh != 0 && c == ' ') {
                break;
            } else {
                if ((c < '0' || c > '9') && c != ' ' && c != '+' && c != '-') {
                    return 0;
                }
            }
        }

        if (sb.length() < 1) {
            return 0;
        }
        BigDecimal re = new BigDecimal(sb.toString()).multiply(new BigDecimal(fh));
        if (re.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) {
            return Integer.MAX_VALUE;
        } else if (re.compareTo(new BigDecimal(Integer.MIN_VALUE)) < 0) {
            return Integer.MIN_VALUE;
        }
        return re.intValue();
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-42"));
        System.out.println(myAtoi("+"));

        System.out.println(myAtoi("42"));

        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("+-12"));
        System.out.println(myAtoi("-+12"));
        System.out.println(myAtoi("++12"));
    }
}
