package com.leetcode.medium;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddNegaBinary {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        if (arr1[0] == 0) {
            return arr2;
        }
        if (arr2[0] == 0) {
            return arr1;
        }
        int i = arr1.length-1;
        int j = arr2.length-1;
        Stack<Integer> result = new Stack<>();
        int remain = 0;
        int carry = 0;
        /**
         * i、j从尾部开始遍历arr1、arr2，当二者都小于0时，说明已经遍历完成
         * 有一个大于0，另一个补0
         * carry不为0时，同时补0
         */
        while(i>=0 | j>=0 | carry != 0){
            carry += (i<0?0:arr1[i--]) + (j<0?0:arr2[j--]);
            remain = carry % (-2);
            carry /= -2;
            /**
             * 被除数 = 余数 + 商 * （-2）
             * 除数为-2，当余数为-1时，需要借位（即+2），也相当于-（-2），此时商需要+1保证被除数不变
             * 即被除数 = 余数 + 2 + （商 + 1）*（-2）
             */
            if (remain < 0){
                remain += 2;
                carry++;
            }
            result.push(remain);
        }
        /**
         * 清除多余的0，如果result全部是0，返回[0]
         */
        while (result.peek() == 0){
            result.pop();
            if(result.isEmpty()){
                return new int [1];
            }
        }
        
        int[] resultArr = new int[result.size()];
        for (int k = 0; k < resultArr.length; k++) {
            resultArr[k] = result.pop();
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[] arr1 = {1};
        int[] arr2 = {1, 1,0,1};
        AddNegaBinary anb = new AddNegaBinary();
        int[] result = anb.addNegabinary(arr1, arr2);
    }

}
