package com.examination.byteDance;

import java.util.Scanner;

public class MainBed {
    public int getBed(int[] clock, int X, int time) {
        if (clock == null) {
            return 0;
        }
        int length = clock.length;
        if (length == 0) {
            return 0;
        }
        int latestTime = time - X;
        int index = 0;
        int getBedTime = clock[index];
        while (getBedTime < latestTime) {
            getBedTime = clock[++index];
        }
        return getBedTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] clock = new int[N];
        for (int i = 0; i < N; i++) {
            clock[i] = sc.nextInt() * 60 + sc.nextInt();
        }
        int X = sc.nextInt();
        int time = sc.nextInt() * 60 + sc.nextInt();
        MainBed main = new MainBed();
        int result = main.getBed(clock, X, time);
        int h = result / 60;
        int m = result - h * 60;
        System.out.println(h + " " + m);
    }
}
