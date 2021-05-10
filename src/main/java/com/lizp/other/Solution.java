package com.lizp.other;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextLine()) {
            String str2 = scan.nextLine();
            System.out.println("输入的数据为：" + str2);
        }
        scan.close();
        String temp="123";

        int[] a = {1, 2, 3, 4, 5, 4, 3, 2, 1, 6};
        Arrays.sort(a);
        int length = a.length;
        if (a[0] != a[1]) {
            System.err.println(a[0]);
            return;
        } else if (a[length - 1] != a[length - 2]) {
            System.err.println(a[length - 1]);
            return;
        }
        for (int i = 1; i < length - 2; i++) {
            if (a[i] != a[i - 1] && a[i] != a[i + 1]) {
                System.err.println(a[i]);
                break;
            }
        }
    }
}
