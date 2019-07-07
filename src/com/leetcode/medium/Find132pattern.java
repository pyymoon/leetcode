package com.leetcode.medium;

import java.util.*;

public class Find132pattern {
    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        if(length < 3){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int second = -2147483648;
        for(int i=length-1;i>=0;i--){
            if(nums[i]<second){
                return true;
            }
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                second = stack.peek();
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,2,-2,1,2};
        Find132pattern fp = new Find132pattern();
        Boolean bl = fp.find132pattern(nums);

    }
}
