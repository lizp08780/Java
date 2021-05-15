package com.lizp.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 */
public class Solution {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        Arrays.sort(num);
        int length = num.length;
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                if (num[i] + num[left] + num[right] == 0) {
                    re.add(new ArrayList<>(Arrays.asList(num[i], num[left], num[right])));
                    int temp = left;
                    left = length;
                    for (int j = temp + 1; j < length; j++) {
                        if (num[temp] != num[j]) {
                            left = j;
                            break;
                        }
                    }
                    temp = right;
                    right = 0;
                    for (int j = temp - 1; j >= 0; j--) {
                        if (num[temp] != num[j]) {
                            right = j;
                            break;
                        }
                    }
                } else if (num[i] + num[left] + num[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[] num = {-2, 0, 1, 1, 2};
        System.out.println(threeSum(num));
    }
}
