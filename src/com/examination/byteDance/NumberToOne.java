package com.examination.byteDance;


import java.util.Scanner;

/**
 * 一个数字 1-10^18   能开方开方 不能开方-1 需要多少次操作减到一
 */
public class NumberToOne {
    public int numberToOne(long number) {
        if (number == 1) {
            return 0;
        }
        int loop = 0;
        while (number != 1) {
            double cur = Math.sqrt(number);
            if (Math.ceil(cur) == cur) {
                number = (int) cur;
            } else {
                number--;
            }
            loop++;
        }
        return loop;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long number = in.nextLong();
        NumberToOne nbt = new NumberToOne();
        int result = nbt.numberToOne(number);
        System.out.println(result);
    }
}
