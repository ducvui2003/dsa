package dsa.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

/**
 * Intersection Sort
 * Best time: O(n)
 * Average time: O(n^2)
 * Worst time: O(n^2)
 */
public class IntersectionSort {
    private int[] intersectionSort(int[] nums) {
        int[] sorted = new int[nums.length];
        sorted[0] = nums[0];
        int current;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            j = i;
            current = nums[i];
            while (j > 0 && sorted[j - 1] > current) {
                int temp = sorted[j];
                sorted[j] = sorted[j - 1];
                sorted[j - 1] = temp;
                j--;
            }
            sorted[j] = current;
        }
        return sorted;
    }

    @Test
    public void testAlreadySorted() {
        int[] input = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };

        assertArrayEquals(expected, intersectionSort(input));
    }

    @Test
    public void testReverseSorted() {
        int[] input = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };

        assertArrayEquals(expected, intersectionSort(input));
    }

    @Test
    public void testRandomNumbers() {
        int[] input = { 5, 2, 8, 1, 3 };
        int[] expected = { 1, 2, 3, 5, 8 };

        assertArrayEquals(expected, intersectionSort(input));
    }

    @Test
    public void testDuplicateNumbers() {
        int[] input = { 4, 2, 4, 1, 2 };
        int[] expected = { 1, 2, 2, 4, 4 };

        assertArrayEquals(expected, intersectionSort(input));
    }

    @Test
    public void testNegativeNumbers() {
        int[] input = { -3, 5, -1, 0, -7 };
        int[] expected = { -7, -3, -1, 0, 5 };

        assertArrayEquals(expected, intersectionSort(input));
    }

    @Test
    public void testSingleElement() {
        int[] input = { 10 };
        int[] expected = { 10 };

        assertArrayEquals(expected, intersectionSort(input));
    }
}
