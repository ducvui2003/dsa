package dsa.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

/**
 * Bubble Sort
 * Best time: O(n)
 * Average time: O(n^2)
 * Worst time: O(n^2)
 */
public class BubbleSort {
    private int[] bubbleSort(int[] nums) {
        for (int j = 0; j < nums.length - 1; j++) {
            // last j element always is a largest element
            for (int i = 1; i < nums.length - j; i++) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }
        }
        return nums;
    }

    @Test
    public void testAlreadySorted() {
        int[] input = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };

        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    public void testReverseSorted() {
        int[] input = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };

        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    public void testRandomNumbers() {
        int[] input = { 5, 2, 8, 1, 3 };
        int[] expected = { 1, 2, 3, 5, 8 };

        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    public void testDuplicateNumbers() {
        int[] input = { 4, 2, 4, 1, 2 };
        int[] expected = { 1, 2, 2, 4, 4 };

        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    public void testNegativeNumbers() {
        int[] input = { -3, 5, -1, 0, -7 };
        int[] expected = { -7, -3, -1, 0, 5 };

        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    public void testSingleElement() {
        int[] input = { 10 };
        int[] expected = { 10 };

        assertArrayEquals(expected, bubbleSort(input));
    }
}
