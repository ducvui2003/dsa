package leet_code._15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
* https://leetcode.com/problems/3sum/description/
* */
import java.util.Map;

public class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//         if(nums.length == 3)
//             return List.of(List.of(1,2,3));
//         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//         for (int i = 0; i < nums.length; i++) {
//             Integer remain = 
//         }
//     }

      // brute force
    public List<List<Integer>> twoSumHint1(int[] nums, int target) {
        if(nums.length == 3)
            return List.of(List.of(1,2,3));
        List<List<Integer>>  results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length && j!=i ; i++) {
               for (int k = 0; k < nums.length&& k!=j && k!=i; k++) {
                    if (nums[j] + nums[k] + nums[i] == 0) {
                        results.add(List.of(nums[i], nums[j], nums[k]));
                }
               }
            }
        }
        return results;
    }

     public int[] twoSumHint3(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[]{
                    0, 1
            };
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            Integer value = map.get(nums[j]);
            if ((value == null))
                map.put(nums[j], j);
            else if (nums[j] * 2 == target)
            // check if 2 index has same value
                return new int[]{
                        Math.min(j, value), Math.max(j, value)
                };
        }

        for (int j = 0; j < nums.length; j++) {
            int remain = target - nums[j];
            Integer index = map.get(remain);
            if (index != null) {
                if (index == j)
                    continue;
                return new int[]{
                        Math.min(j, index), Math.max(j, index)
                };
            }
        }
        return null;
    }

}
