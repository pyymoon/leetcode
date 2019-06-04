package org.swordOffer;

public class Fibonacci {
    public int fibonacci(int n){
        int f1=0;
        int f2=1;
        int f3=0;
        if (n==0){return 0;}
        if(n==1){return 1;}
        for (int i = 2; i <= n; i++) {
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static void main(String[] args) {

        Fibonacci f = new Fibonacci();
        for (int i = 0; i < 50; i++) {
            System.out.print(f.fibonacci(i)+" ");
        }

    }
}
