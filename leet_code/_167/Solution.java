package leet_code._167;

/*
* https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/1736978461/
* */
import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target)
                break;
            if (numbers[i] + numbers[j] > target)
                j--;
            else
                i++;
        }
        return new int[]{numbers[i], numbers[j]};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        Solution so = new Solution();
        System.out.println(Arrays.toString(so.twoSum(arr, 3)));
    }
}
