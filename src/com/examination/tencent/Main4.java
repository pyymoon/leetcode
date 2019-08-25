package com.examination.tencent;

import java.util.Scanner;

public class Main4 {
    public int findLou(int[] array, int n, int index) {
        int qian = 0;
        int hou = 0;
        if (index == 0) {
        } else {
            int temp = array[index - 1];
            for (int i = index - 1; i >= 0; i--) {
                if (array[i] >= temp) {
                    temp = array[i];
                    qian++;
                }
            }
        }
        int rest = array.length - 1 - index;
        if (rest == 0) {
        } else {
            int temp = array[index + 1];
            for (int i = index + 1; i < array.length; i++) {
                if (array[i] >= temp) {
                    temp = array[i];
                    hou++;
                }
            }
        }
        return (qian + hou + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        Main4 main = new Main4();
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int result = main.findLou(w, n, i);
            System.out.print(result + " ");
        }
    }
}
