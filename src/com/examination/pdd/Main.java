package com.examination.pdd;

import java.util.Scanner;

/**
 * 给定N个整数，找出其中方差最小的三个数
 */
public class Main {
    public Double getAverage(int a, int b, int c) {
        double ave = (double) (a + b + c) / 3;
        return ave;
    }

    public Double getFangCha(int a, int b, int c) {
        double ave = getAverage(a, b, c);
        double sum = 0;
        sum = Math.pow((a - ave), 2) + Math.pow((b - ave), 2) + Math.pow((c - ave), 2);
        double fangCha = sum / 3;
        return fangCha;
    }

    public Double getMinFangCha(Integer[] array) {
        int length = array.length;
        double min = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (min == 0) {
                        min = getFangCha(array[i], array[j], array[k]);
                    } else {
                        double temp = getFangCha(array[i], array[j], array[k]);
                        if (temp < min) {
                            min = temp;
                        }
                    }
                }
            }
        }
        String str = String.format("%.2f", min);
        return Double.valueOf(str);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        Main fm = new Main();
        double result = fm.getMinFangCha(array);
        System.out.println(result);
    }
}
