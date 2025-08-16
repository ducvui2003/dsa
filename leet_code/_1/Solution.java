package leet_code._1;

import java.util.HashMap;

public class Solution {

    // brute force
    public int[] twoSumHint1(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[]{
                    0, 1
            };
        }

        for (int j = 0; j < nums.length; j++) {
            for (int i = j + 1; i < nums.length; i++) {
                if (nums[j] + nums[i] == target) {
                    return new int[]{
                            Math.min(j, i), Math.max(j, i)
                    };
                }
            }
        }
        return null;
    }


    public int[] twoSumHint2(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[]{
                    0, 1
            };
        }

        for (int j = 0; j < nums.length; j++) {
            int remain = target - nums[j];
            for (int i = j + 1; i < nums.length; i++) {
                if (nums[i] == remain) {
                    return new int[]{
                            Math.min(j, i), Math.max(j, i)
                    };
                }
            }
        }
        return null;
    }

    // Use hash map
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

    public static void main(String[] args) {
        Solution tw = new Solution();
        System.out.println(tw.twoSumHint3(new int[]{3, 2, 4}, 6));
    }
}
