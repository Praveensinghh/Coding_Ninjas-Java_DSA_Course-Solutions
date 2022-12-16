/**
 * QuickSort
 */
public class QuickSort {

    public static void quickSort(int[] input) {
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * No need to print or return the output.
         * Taking input and printing output is handled automatically.
         */
        quickSort(input, 0, input.length - 1);
    }

    public static void quickSort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = input[start];
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (input[i] < pivot) {
                count++;
            }
        }
        int temp = input[start + count];
        input[start + count] = pivot;
        input[start] = temp;
        int i = start, j = end;
        while (i < start + count && j > start + count) {
            if (input[i] < pivot) {
                i++;
            } else if (input[j] >= pivot) {
                j--;
            } else {
                temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(input, start, start + count - 1);
        quickSort(input, start + count + 1, end);
    }
}