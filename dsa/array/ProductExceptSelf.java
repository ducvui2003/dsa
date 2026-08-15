package dsa.array;

import java.util.Arrays;
import java.util.Objects;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        Integer[] out = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length && j != i; j++) {
                out[i] = (out[i] == null ? 1 : out[i]) * nums[j];
            }
        }

        return Arrays.stream(out).filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 4, 6
        };
        ProductExceptSelf self = new ProductExceptSelf();
        System.out.println(self.productExceptSelf(nums));
    }
}
