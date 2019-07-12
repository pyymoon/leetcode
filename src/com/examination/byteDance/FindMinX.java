package com.examination.byteDance;

import java.util.Scanner;

/**
 * 给定n，找到满足 y^2 = n + x^2的最小x
 */
public class FindMinX {
    public long findMinX(long n) {
        if(isSqrt(n)){

            n = (long)Math.sqrt(n);
            if (n<3){
                return -1;
            }
            if(n%2 == 0){
                return n*n/4 - 1;
            }else {
                return n*n/2;
            }
        }else{
            if(isSqrt(n+1)){
                return 1;
            }else {
                return -1;
            }
        }
    }

    public static boolean isSqrt(long n){
        double cur = Math.sqrt(n);
        if(Math.ceil(cur) == cur){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FindMinX main = new FindMinX();
        int m = in.nextInt();
        long[] arr = new long[m];
        for (int i = 0; i < m; i++) {
            long n = in.nextLong();
            arr[i] = main.findMinX(n);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(arr[i]);
        }
    }
}

