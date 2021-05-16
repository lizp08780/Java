package com.lizp.other;

import java.util.Scanner;

public class Solution02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int sum = 0;
            for (int i = 0; i < line.length() - 2; i++) {
                int temp = 1;
                for (int j = 0; j < i; j++) {
                    temp *= 16;
                }
                sum = sum + temp * char2Int(line.charAt(line.length() - 1 - i));
            }
            System.out.println(sum);
        }
    }

    public static int char2Int(char x){
        if(x>='0' && x<='9'){
            return x-48;
        }else if(x>='A' && x<='Z'){
            return x-'A'+10;
        }else{
            return x-'a'+10;
        }
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
