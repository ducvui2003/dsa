package al;

public class InsertionSort implements ISort {
    @Override
    public int[] sort(int[] arr) {
        if (arr.length == 1)
            return arr;

        int p = 1;
        int i = 0;
        while (i <= arr.length) {
            if (arr[i] > arr[p]) {
                int temp = arr[i];
                arr[i] = arr[p];
                arr[p] = temp;
                i++;
            }
        }
        return new int[0];
    }
}
