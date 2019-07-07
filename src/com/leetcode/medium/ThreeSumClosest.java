package com.leetcode.medium;

import java.util.Arrays;

public class ThreeSumClosest {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int sum=0;
            int closeNum = nums[0] + nums[1] + nums[2];
            for(int i=0;i<nums.length-2;i++){
                int left=i+1;
                int right = nums.length - 1;
                while(left<right){
                    sum = nums[i]+nums[left]+nums[right];
                    if(Math.abs(sum-target)<Math.abs(closeNum-target)){
                        closeNum = sum;
                    }
                    if(sum>target){while(right>1 && nums[right--]==nums[right]){}}
                    else if(sum<target){while(left<nums.length-1 && nums[left++]==nums[left]){}}
                    else{
                        return target;
                    }
                }
            }
            return closeNum;
        }

        public static void main(String[] args) {
            int[] num = {0,1,1,1};
            int target = 100;
            ThreeSumClosest tnc = new ThreeSumClosest();
            int close = tnc.threeSumClosest(num,target);
        }
    }