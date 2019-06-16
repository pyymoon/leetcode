package com.leetcode.medium;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {
    /**
     * 每次插入hashMap时都去已有的HashMap中寻找满足0-nums[i]
     * 的两个数，时间复杂度为o(n2)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lastList = new ArrayList<>();
//        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new IdentityHashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> list = new ArrayList<>(2);
//            list.add(0,i);
//            list.add(1,2);
//            map.put(nums[i], list);
//        }
        for (int i = 0; i < nums.length; i++) {
            int result = 0 - nums[i];
            int isRepeat;
            if(nums[i]!=0 & map.size() != 0) {
                if (map.containsKey(nums[i])) {
                    isRepeat = map.get(nums[i]).get(1);
                    if (isRepeat == 0) {
                        continue;
                    }
                    isRepeat--;
                    map.get(nums[i]).add(1, isRepeat);
                }
            }
            for (int j = 0; j < i; j++) {
                int lastResult = result - nums[j];
                if (map.containsKey(lastResult) && map.get(lastResult).get(0) != j &&map.get(lastResult).get(0) != i) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[map.get(lastResult).get(0)]);
                    list.add(nums[j]);
                    list.add(nums[i]);
                    Collections.sort(list);
                    if (!lastList.contains(list)){
                        lastList.add(list);
                    }
                }
            }
            List<Integer> list = new ArrayList<>(2);
            list.add(0,i);
            list.add(1,2);
            map.put(nums[i], list);
        }
        return lastList;
    }

    /**
     * 左右同时查找s
     * @param nums
     * @return
     */
    public List<List<Integer>> sortThreeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> lastList = new ArrayList<>();
        int length = nums.length;
        if (nums[0]>0 | nums[length-1]<0){
            return null;
        }
        for (int i = 0; i < length - 2; i++) {
            int left = i+1;
            int right = length - 1;
            while(left<right) {
                if (nums[i]*nums[right]>0){break;}
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    lastList.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left] == nums[left-1]){left++;}
                    while(left<right && nums[right] == nums[right+1]){right--;}
                }
                else if (sum<0){
                    left++;
                }
                else if(sum>0){
                    right--;
                }
            }
        }
        return lastList;
    }


    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> lastList = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int result = 0 - nums[i];
            if (nums[i] != 0){
                if(i>1 && nums[i-2]==nums[i]){
                    continue;
                }
            }
            for (int j = 0; j < i; j++) {
                int lastResult = result - nums[j];
                if (map.containsKey(lastResult) && map.get(lastResult)!=j) {
                    List<Integer> list = new ArrayList<>();

                    list.add(nums[j]);
                    list.add(nums[map.get(lastResult)]);
                    list.add(nums[i]);
                    if(lastList.contains(list))
                    lastList.add(list);

                }
            }
            map.put(nums[i], i);
        }
        return lastList;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length < 3){
            return list;
        }

        Arrays.sort(nums);
        if(nums[0]>0 | nums[nums.length-1]<0){
            return list;
        }
        for(int i=0;i<nums.length;i++){System.out.print(nums[i]+",");}
        System.out.print("\n");
        int sum=0;
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){continue;}
            int left=i+1;
            int right = nums.length - 1;
            while(left<right){
                if((nums[i]<0&nums[right]<0)|(nums[i]>0&nums[right]>0)){break;}
                sum = nums[i]+nums[left]+nums[right];
                if(left==1722 && right == 2802){
                    System.out.println("");
                }
                if(sum==0){
                    List<Integer> temp = new ArrayList<>();
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(right>1 && nums[right--]==nums[right]){}
                    while(left<nums.length-1 && nums[left++]==nums[left]){}
                }
                else if(sum>0){while(right>1 && nums[right--]==nums[right]){}}
                else{while(left<nums.length-1 && nums[left++]==nums[left]){}}
            }
        }
        return list;
    }

    public static void main(String[] args) {

//        int[] array = {,324,1202,-90885,-2989,-95597,-34333,35528,5680,89093,-90606,50360,-29393,-27012,53313,65213,99818,-82405,-41661,-3333,-51952,72135,-1523,26377,74685,96992,92263,15929,5467,-99555,-43348,-41689,-60383,-3990,32165,65265,-72973,-58372,12741,-48568,-46596,72419,-1859,34153,62937,81310,-61823,-96770,-54944,8845,-91184,24208,-29078,31495,65258,14198,85395,70506,-40908,56740,-12228,-40072,32429,93001,68445,-73927,25731,-91859,-24150,10093,-
    }
}
