package leet_code._128;

import java.util.Arrays;

/*
 * SRC: https://leetcode.com/problems/longest-consecutive-sequence/description
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxCount = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 0)
                continue;
            if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        return  Math.max(maxCount, count);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6
        };
        Solution lcs = new Solution();
        System.out.println(lcs.longestConsecutive(arr
        ));
    }
}
