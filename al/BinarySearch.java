package al;


public class BinarySearch {
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

    public static void main(String[] args) {
        BinarySearch s = new BinarySearch();
        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};

        System.out.println(s.search(arr, 2));
    }
}
