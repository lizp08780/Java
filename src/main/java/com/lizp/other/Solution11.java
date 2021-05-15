package com.lizp.other;

/**
 *
 */
public class Solution11 {

    public static void main(String[] args) {
        System.err.println(-123%10);
    }

    public static String solve (String str) {
        int n=str.length();
        if(n<=1){
            return str;
        }
        char[] arr=new char[n];
        for(int i=0;i<n/2;i++){
            arr[i]=str.charAt(n-i-1);
            arr[n-1-i]=str.charAt(i);
        }
        if(n%2==1){
            arr[n/2+1]=str.charAt(n/2+1);
        }
        System.err.println(new StringBuilder(str).reverse());
        return String.valueOf(arr);
    }
}
