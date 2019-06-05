package com.examination.vivo;


import java.io.IOException;

public class DeleteElement {
    public void deleteElement(int[] arrA,int[] arrB) throws IOException {
        if(arrA.length == 0){
            throw new IOException("非法输入");
        }
        if(arrB.length == 0){

        }
        int sum = arrA.length;
        for (int i = 0; i < arrB.length; i++) {
            if(arrA.length!=0) {
                int index = 0;
                for (int j = 0; j < sum; j++) {
                    if (arrB[i] != arrA[j]) {
                        arrA[index] = arrA[j];
                        index++;
                    }
                }
                sum = index;
            }
        }
        for (int i = 0; i < sum; i++) {
            System.out.print(arrA[i]+" ");
        }
    }

    public static void main(String[] args) throws IOException{
        int[] arrA = {};
        int[] arrB = {2,5};
        DeleteElement de = new DeleteElement();
//        try{
            de.deleteElement(arrA,arrB);
//        }catch (Exception e){
//            System.out.print(e.getMessage());
//        }
    }
}
