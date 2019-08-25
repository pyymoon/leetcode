package com.examination.tencent;

import java.util.Scanner;

public class Main2 {
    private void fanZhuan(int[] array, int[] newArr, int start, int end) {
        int j = start;
        for (int i = end - 1; i >= start; i--) {
            newArr[j++] = array[i];
        }
    }

    private int getNiXu(int[] array) {
        int sum = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[0]) {
                sum++;
            }
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                sum += sum;
            } else if (array[i] < array[i - 1]) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] < array[i]) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    private int getNixuV1(int[] array) {
        int[] result = new int[1];
        mergeSort(array, 0, array.length - 1, result);
        return 0;
    }

    private void mergeSort(int[] array, int start, int end, int[] result) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid, result);
            mergeSort(array, mid, end, result);
            //TODO 归并排序
//            merge()
        }
    }

//    private void merge()

    public int[] fanZhuanAll(int[] array, int m, int[] q, int n) {
        int[] result = new int[m];
        int length = (int) Math.pow(2, n);
        for (int i = 0; i < m; i++) {
            int groupLen = (int) Math.pow(2, q[i]);
            int groupNum = length / groupLen;
            int[] newArr = new int[length];
            for (int j = 0; j < groupNum; j++) {
                fanZhuan(array, newArr, j * groupLen, (j + 1) * groupLen);
            }
            result[i] = getNiXu(newArr);
            array = newArr;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int length = (int) Math.pow(2, n);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] q = new int[m];
        for (int i = 0; i < m; i++) {
            q[i] = sc.nextInt();
        }
        Main2 main = new Main2();
        int[] result = main.fanZhuanAll(array, m, q, n);
        for (int i = 0; i < m; i++) {
            System.out.println(result[i]);
        }
    }
}
