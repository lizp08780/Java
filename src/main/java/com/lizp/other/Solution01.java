package com.lizp.other;

/**
 * s顺时针旋转矩阵
 */
public class Solution01 {
    public static void main(String[] args) {
        int size = 9;
        int[][] a = new int[size][size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = ++count;
            }
        }
        print(a, size);
        //rotote90(size, a);
        //rotote90(size, a);
        //rotote90(size, a);
        rotote270(size, a);
        print(a, size);
    }

    /**
     * 正向旋转90度
     *
     * @param size
     * @param a
     */
    private static void rotote90(int size, int[][] a) {
        for (int i = 0; i < size / 2; i++) {
            //j < size - i - 1;易错
            for (int j = i; j < size - i - 1; j++) {
                int temp = a[i][j];
                a[i][j] = a[size - 1 - j][i];
                a[size - 1 - j][i] = a[size - 1 - i][size - 1 - j];
                a[size - 1 - i][size - 1 - j] = a[j][size - 1 - i];
                a[j][size - 1 - i] = temp;
            }
        }
    }

    /**
     * 正向旋转180度
     *
     * @param size
     * @param a
     */
    private static void rotote180(int size, int[][] a) {
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size; j++) {
                int temp = a[i][j];
                a[i][j] = a[size - 1 - i][size - 1 - j];
                a[size - 1 - i][size - 1 - j] = temp;
            }
        }
        if (size % 2 == 1) {
            for (int j = 0; j < size / 2; j++) {
                int temp = a[size / 2][j];
                a[size / 2][j] = a[size - 1 - size / 2][size - 1 - j];
                a[size - 1 - size / 2][size - 1 - j] = temp;
            }
        }
    }

    /**
     * 正向旋转270度
     *
     * @param size
     * @param a
     */
    private static void rotote270(int size, int[][] a) {
        for (int i = 0; i < size / 2; i++) {
            for (int j = i; j < size - i - 1; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][size - 1 - i];
                a[j][size - 1 - i] = a[size - 1 - i][size - 1 - j];
                a[size - 1 - i][size - 1 - j] = a[size - 1 - j][i];
                a[size - 1 - j][i] = temp;
            }
        }
    }

    public static void print(int[][] a, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.err.print(String.format("%4d", a[i][j]));
            }
            System.err.println();
        }
        System.err.println();
    }
}
