package leet_code._15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* https://leetcode.com/problems/3sum/description/
* */

public class Solution {

    // brute force
    public List<List<Integer>> thrreeSumHint1(int[] nums) {
        if (nums.length == 3 && nums[0] + nums[1] + nums[2] == 0)
            return List.of(List.of(nums[0], nums[1], nums[2]));
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // a + b +c == 0 => at least a < 0 || b < 0 || c < 0
            if (nums[i] > 0)
                break;

            // i < l < r
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[i] + nums[r];
                if (sum == 0) {
                    results.add(List.of(nums[l], nums[i], nums[r]));

                    // Skip duplicate
                    while (l < r && nums[l] == nums[l + 1])
                        l++;
                    while (l < r && nums[r] == nums[r - 1])
                        r--;
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }

            }
        }
        return results;
    }
}
