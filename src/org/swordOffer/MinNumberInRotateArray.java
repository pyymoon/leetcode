package org.swordOffer;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array==null | array.length==0){
            return 0;
        }
        int left=0;int right=array.length-1;
        while(true){
            int mid = (left+right)/2;

            if(array[mid]>array[left] | array[mid]>array[right]){
                left = mid;
            }
            else if (array[mid]<array[right]){
                right = mid;
            }
            else if(array[mid] == array[right]){
                int min=array[0];
                for (int i=0;i<array.length;i++){
                    if(array[i]<min){
                        min = array[i];
                    }
                }
                return min;
            }
            if(right - left == 1 | right == left){
                return array[left]>array[right]?array[right]:array[left];
            }
        }
//        return array[left];
    }

    public static void main(String[] args) {
        MinNumberInRotateArray min = new MinNumberInRotateArray();
//        int[] array = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        int[] array = {1,0,1,1,1};
        int minNum = min.minNumberInRotateArray(array);
        System.out.println(minNum);
    }
}
