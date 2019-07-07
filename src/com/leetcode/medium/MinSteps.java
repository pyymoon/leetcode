package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class MinSteps {
    public int minSteps(int n) {
        int step = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                step += i;
                n = n / i;
            }
        }
        return step;
    }

    public void printSteps(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                list.add(i);
                n = n / i;
            }
        }
        StringBuffer str = new StringBuffer();
        str.append('A');
        System.out.print(str.length()+" ");
        System.out.println(str);
        for (int i = 1; i < list.size(); i++) {
            System.out.println("copy");
            String temp = str.toString();
            //共输出list.get(i)-1次
            for (int j = 0; j < list.get(i)-1; j++) {
                //复制之后添加temp
                str.append(temp);
                System.out.print(str.length()+" ");
                System.out.println(str);
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        MinSteps ms = new MinSteps();
        ms.printSteps(n);
    }
}


