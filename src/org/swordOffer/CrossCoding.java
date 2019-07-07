package org.swordOffer;

public class CrossCoding {
    public int[] crossCoding(int[] array,int n){
        if(array==null){
            return null;
        }
        int length = array.length;
        if(length < n*n){
            int[] copy = new int[n*n];
            copy = array;
        }
        else if(length > n*n){
            int[] copy = new int[(n+1)*(n+1)];
            copy = array;
        }
        int[] newArray = new int[length];
        if(length==0){
            return newArray;
        }
        int loop = 0;
        int index;
        int newIndex=0;
        for (int i = 0; i < length; i++) {
            index = n*(newIndex%n)+loop;
            if(index<length) {
                newArray[i] = array[index];
                if(newIndex%n == n-1){
                    loop++;
                }
                newIndex++;
            }
            else{
                loop++;
                while(index>=length){
                    index = ((++newIndex)%n) * n + loop;
                }
                newArray[i] = array[index];
                newIndex++;
            }
        }
        return newArray;
    }

    public Integer[] crossCoding1(Integer[] array,int n){
        if(array==null){
            return null;
        }
        int length = array.length;
        if(array.length == 0){
            return array;
        }
        int n1 = n*n;int cols = n;int n2,newLen;
        if(length>n1){
            //array转化成的二维数组的行数
            cols = length/n==0?length/n:length/n+1;
            int temp = n;
            while((temp++)*temp<length){}
            //array转化成的二维数组的大小
            n2 = temp*temp;
            newLen = n2;
        }
        else{
            newLen = n1;
        }
        Integer[] copy = new Integer[newLen];
        //补齐array，不够的补null
        for (int i = 0; i < newLen; i++) {
                if(i<length) {
                    copy[i] = array[i];
                }
                else{
                    copy[i] = null;
                }
            }
        Integer[] newArray = new Integer[newLen];
        Integer[] result = new Integer[length];
        int loop = 0;int index;int newIndex=0;
        for (int i = 0; i < newLen; i++) {
            index = n * (i % cols) + loop;
            if(copy[index] != null) {
                newArray[newIndex++] = copy[index];
            }
            if(i%cols == cols-1){
                loop++;
            }
        }
        //null全部集中在最后面，直接抛弃
        for (int i = 0; i < length; i++) {
            result[i] = newArray[i];
        }
        return result;
    }
    public static void main(String[] args) {
        CrossCoding cc = new CrossCoding();
        Integer[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int n=3;
        Integer[] newArray;
        newArray = cc.crossCoding1(array,n);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]+" ");
        }
    }
}
