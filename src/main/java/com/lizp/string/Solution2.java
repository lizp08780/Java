package com.lizp.string;

public class Solution2 {
    public static String LCS(String str1, String str2) {
        // write code here
        String a = str1;
        String b = str2;
        if (str2.length() > str1.length()) {
            a = str2;
            b = str1;
        }
        for (int i = b.length(); i > 0; i--) {
            for (int j = 0; j < b.length() - i + 1; j++) {
                String sub = b.substring(j, j + i);
                if (a.contains(sub)) {
                    return sub;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(LCS("1AB2345CD", "1abc"));
    }
}
