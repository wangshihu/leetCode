package com.huihui.util;

/**
 * Created by hadoop on 2015/6/1 0001.
 */
public class ArrayUtil {
    public static String arrToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + ",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void printCharArr(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String arrToString(int[] arr, int k) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < k; i++) {
            sb.append(arr[i] + ",");
        }
        sb.append("]");
        return sb.toString();

    }


    public static void reverseArr(int[] arr, int begin, int end) {
        for (; begin < end; begin++, end--) {
            int temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
        }
    }

    public static char[][] switchStringArrToChar(String[] arr) {
        char[][] result = new char[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i].toCharArray();
        }
        return result;
    }

}
