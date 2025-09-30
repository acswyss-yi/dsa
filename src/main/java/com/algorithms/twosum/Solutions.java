package com.algorithms.twosum;

import java.util.HashMap;

public class Solutions
{
//    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//        }
//        return result; // Return an empty array if no solution is found
//    }
public int[] twoSum(int[] nums, int target) {
   HashMap<Integer,Integer> hashhMap=new HashMap<Integer, Integer>();
   for (int i=0; i<nums.length;i++){
       if(hashhMap.containsKey(target-nums[i])){
              return new int[]{hashhMap.get(target-nums[i]),i};
       }
       hashhMap.put(nums[i],i);
   }
   return new int[0]; // Return an empty array if no solution is found
}
}
