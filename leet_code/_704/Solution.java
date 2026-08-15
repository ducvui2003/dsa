package leet_code._704;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (target > nums[middle]) {
                left = middle + 1;
                continue;
            }
            if (target < nums[middle]) {
                right = middle;
                continue;
            }
            if (target == nums[middle]) {
                return middle;
            }
        }
        return -1;
    }
}
