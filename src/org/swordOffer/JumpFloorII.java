package org.swordOffer;

import java.util.ArrayList;

public class JumpFloorII {
    public int jumpFloorII(int target){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        if(target == 1){return 1;}
        for(int i=2;i<=target;i++){
            int sum=0;
            for (Integer j:list
                 ) {
                sum += j;
            }
            list.add(sum);
        }
        return list.get(target);
    }

    public static void main(String[] args) {
        JumpFloorII jumpFloorII = new JumpFloorII();
        for (int i = 0; i < 10; i++) {
            System.out.print(jumpFloorII.jumpFloorII(i)+" ");
        }
    }
}
