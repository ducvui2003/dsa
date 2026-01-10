/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums) {
    const result = [];
    const arr = nums.sort((a, b) => a - b);
    for (let i = 0; i < arr.length; i++) {
        // Skip duplicate
        if (i > 0 && nums[i] === nums[i - 1]) continue;

        // a + b +c == 0 => at least a < 0 || b < 0 || c < 0
        if (nums[i] > 0) break;

        let l = i + 1; r = arr.length - 1;

        while (l < r) {
            const sum = nums[i] + nums[l] + nums[r];
            if (sum == 0) {
                result.push([nums[i], nums[l], nums[r]]);
                // Skip duplicate
                while (l < r && nums[l] === nums[l + 1]) l++;
                while (l < r && nums[r] === nums[r - 1]) r--;
                l++;
                r--;
            } else if (sum < 0)
                l++;
            else r--;
        }
    }
    return result;
};