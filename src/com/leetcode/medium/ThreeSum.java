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

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = 0 - nums[i];
            for (int j = 0; j < i; j++) {
                int lastResult = result - nums[j];
                if (map.containsKey(lastResult) && map.get(lastResult)!=j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[map.get(lastResult)]);
                    Collections.sort(list);
                    if (!lastList.contains(list)){
                        lastList.add(list);
                    }
                }
            }
            map.put(nums[i], i);
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
                    while(left<right && nums[left] == nums[left--]){left++;}
                    while(left<right && nums[right] == nums[right++]){right--;}
                }
                else if (left<right && sum<0){
                    left++;
                }
                else if(left<right && sum>0){
                    right--;
                }
            }
        }
        return lastList;
    }
}
