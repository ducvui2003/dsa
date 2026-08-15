package leet_code._238;

import java.util.Arrays;

/*
* https://leetcode.com/problems/product-of-array-except-self/description/
* */
public class ProductArraySelf       {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] result = new int[nums.length];
        int [] postfix = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0)
                product *= nums[i-1];
          prefix[i] =product;
        }
        product = 1;
        for (int i = nums.length-1; i >= 0 ; i--) {
            if (i != nums.length-1)
                product *= nums[i+1];
            postfix[i] = product;
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * postfix[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6};
        ProductArraySelf productArraySelf = new ProductArraySelf();
        System.out.println(Arrays.toString(productArraySelf.productExceptSelf(arr)));
    }
}
