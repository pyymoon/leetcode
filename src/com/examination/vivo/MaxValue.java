package com.examination.vivo;


/**
 * 给定物品，有两个属性，热度（价值）与单价，求给定总钱数的情况下价值最大的买法
 */
public class MaxValue {
    public int[] maxValue(int[] value,int[] price,int total){
        int n = value.length;
        int[] totalValue = new int[total+1];
        for (int i = 1; i <= n; i++) {
            for (int j = total; j >= price[i-1]; j--) {
                totalValue[j] = totalValue[j] > (totalValue[j-price[i-1]]+value[i-1])?totalValue[j]:(totalValue[j-price[i-1]]+value[i-1]);
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        int[] price = {2,2,6,5,4};
        int[] value = {6,3,5,4,6};
        int total = 10;
        MaxValue maxValue = new MaxValue();
        int[] max = maxValue.maxValue(value,price,total);
        for (int i = 1; i <= total; i++) {
            System.out.print(max[i]+" ");
        }
    }
}
