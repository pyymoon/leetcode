package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] vilonce(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 第一遍将数组与下标存入hashMap中，第二次查找
     * target-nums[i]时只需要o(1)的时间复杂度.
     */

    public int[] twoHash(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if(map.containsKey(result) && map.get(result)!=i){
                return new int[] {i,map.get(result)};
            }
        }
        throw new IllegalArgumentException("no target");
    }

    /**
     *可以只用一次哈希表，插入的同时回头查找hashMap
     * 中是否存在目标值
     */
    public int[] oneHash(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result) && map.get(result)!=i){
                return new int[] {i,map.get(result)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no target");
    }
}
