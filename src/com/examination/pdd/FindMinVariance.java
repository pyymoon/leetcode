package com.examination.pdd;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindMinVariance {
    public double findMinVariance(int[] array, int length) {
        Arrays.sort(array);
        int[] temp = new int[length - 1];
        double result;
        for (int i = 0; i < length - 1; i++) {
            temp[i] = Math.abs((array[i] - array[i + 1]));
        }
        List<Integer> list = findMinIndex(temp);
        int minIndex = list.get(0);
        int secondIndex = list.get(1);
        if (minIndex > secondIndex) {
            result = getFangCha(array[secondIndex], array[minIndex], array[minIndex + 1]);
        } else {
            result = getFangCha(array[minIndex], array[secondIndex], array[secondIndex + 1]);
        }
        return result;
    }

    public List<Integer> findMinIndex(int[] array) {
        int min = 0;
        int index = 0;
        int indexSecond = 1;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                min = array[0];
            } else {
                if (array[i] < min) {
                    min = array[i];
                    index = i;
                }
            }
        }
        if (index == array.length - 1) {
            indexSecond = array.length - 2;
        } else if (index > 0) {
            indexSecond = array[index - 1] > array[index + 1] ? (index + 1) : (index - 1);
        }
        return Arrays.asList(index, indexSecond);
    }

    public Double getAverage(int a, int b, int c) {
        double ave = (double) (a + b + c) / 3;
        return ave;
    }

    public Double getFangCha(int a, int b, int c) {
        double ave = getAverage(a, b, c);
        double sum = 0;
        sum = Math.pow((a - ave), 2) + Math.pow((b - ave), 2) + Math.pow((c - ave), 2);
        String str = String.format("%.2f", sum / 3);
        return Double.valueOf(str);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        FindMinVariance fm = new FindMinVariance();
        double result = fm.findMinVariance(array, length);
        System.out.println(result);
    }
}
