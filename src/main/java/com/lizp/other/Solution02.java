package com.lizp.other;

import java.util.Scanner;

public class Solution02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a * b / fun(a, b));
        }
        sc.close();
    }

    public static int fun(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int k;
        while (b != 0) {
            k = a % b;
            a = b;
            b = k;
        }
        return a;

    }
}
