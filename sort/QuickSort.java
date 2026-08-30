package sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

/**
 * Quick Sort
 * L = 0
 * R = arr.length - 1
 * P = L (pivot)
 * if arr[R] > P -> R--
 * if arr[R] < P -> arr[L] = arr[R], L++
 * if arr[L] < P -> L++
 * if arr[L] > P -> arr[R] = arr[L], R++
 * if L == R -> arr[L] = P (end recursive)
 * => Get 3 list: [0 to L - 1] [L] [L + 1 to arr.length - 1]
 * Recursive util to each list have 1 item
 */
public class QuickSort {
    public void sort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            sort(arr, p, q - 1);
            sort(arr, q + 1, r);
        }
    }

    public int partition(int[] arr, int p, int r) {
        int pivot = arr[p]; // pivot
        int i = p; // left → right
        int j = r; // right → left
        while (i < j) {
            while (i < j && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < pivot) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = pivot;
        return i;
    }

    @Test
    public void test() {
        // 1. Normal / random
        int[] input1 = { 6, 3, 2, 4, 1, 8, 7, 5 };
        sort(input1, 0, input1.length - 1);
        int[] expected1 = { 1, 2, 3, 4, 5, 6, 7, 8 };

        // 2. Already sorted
        int[] input2 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        sort(input2, 0, input2.length - 1);
        int[] expected2 = { 1, 2, 3, 4, 5, 6, 7, 8 };

        // 3. Reverse sorted
        int[] input3 = { 8, 7, 6, 5, 4, 3, 2, 1 };
        sort(input3, 0, input3.length - 1);
        int[] expected3 = { 1, 2, 3, 4, 5, 6, 7, 8 };

        // 4. One element
        int[] input4 = { 5 };
        sort(input4, 0, input4.length - 1);
        int[] expected4 = { 5 };

        // 5. Empty array
        int[] input5 = {};
        sort(input5, 0, input5.length - 1);
        int[] expected5 = {};

        // 6. Two elements - unsorted
        int[] input6 = { 2, 1 };
        sort(input6, 0, input6.length - 1);
        int[] expected6 = { 1, 2 };

        // 7. Two elements - sorted
        int[] input7 = { 1, 2 };
        sort(input7, 0, input7.length - 1);
        int[] expected7 = { 1, 2 };

        // 8. Duplicate values
        int[] input8 = { 5, 3, 5, 2, 5, 1, 5 };
        sort(input8, 0, input8.length - 1);
        int[] expected8 = { 1, 2, 3, 5, 5, 5, 5 };

        // 9. All values are the same
        int[] input9 = { 5, 5, 5, 5, 5 };
        sort(input9, 0, input9.length - 1);
        int[] expected9 = { 5, 5, 5, 5, 5 };

        // 10. Negative numbers
        int[] input10 = { 3, -2, 5, -8, 0, 1, -1 };
        sort(input10, 0, input10.length - 1);
        int[] expected10 = { -8, -2, -1, 0, 1, 3, 5 };

        // 11. Negative + duplicate + zero
        int[] input11 = { 0, -1, 5, -1, 3, 0, -5 };
        sort(input11, 0, input11.length - 1);
        int[] expected11 = { -5, -1, -1, 0, 0, 3, 5 };

        // 12. Pivot is smallest
        int[] input12 = { 1, 5, 3, 8, 2, 7, 4, 6 };
        sort(input12, 0, input12.length - 1);
        int[] expected12 = { 1, 2, 3, 4, 5, 6, 7, 8 };

        // 13. Pivot is largest
        int[] input13 = { 8, 5, 3, 1, 7, 2, 4, 6 };
        sort(input13, 0, input13.length - 1);
        int[] expected13 = { 1, 2, 3, 4, 5, 6, 7, 8 };

        // 14. Pivot in the middle
        int[] input14 = { 5, 3, 1, 8, 7, 6, 2, 4 };
        sort(input14, 0, input14.length - 1);
        int[] expected14 = { 1, 2, 3, 4, 5, 6, 7, 8 };

        assertArrayEquals(expected1, input1);
        assertArrayEquals(expected2, input2);
        assertArrayEquals(expected3, input3);
        assertArrayEquals(expected4, input4);
        assertArrayEquals(expected5, input5);
        assertArrayEquals(expected6, input6);
        assertArrayEquals(expected7, input7);
        assertArrayEquals(expected8, input8);
        assertArrayEquals(expected9, input9);
        assertArrayEquals(expected10, input10);
        assertArrayEquals(expected11, input11);
        assertArrayEquals(expected12, input12);
        assertArrayEquals(expected13, input13);
        assertArrayEquals(expected14, input14);
    }
}
