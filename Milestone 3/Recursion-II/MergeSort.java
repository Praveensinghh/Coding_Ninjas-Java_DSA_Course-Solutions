import java.util.Scanner;

/**
 * MergeSort
 */
public class MergeSort {

    public static void mergeSort(int[] input) {
        // Write your code here
        if (input.length <= 1) {
            return;
        }
        int mid = input.length / 2;

        int[] left = new int[mid];
        int[] right = new int[input.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = input[i];
        }

        for (int i = mid; i < input.length; i++) {
            right[i - mid] = input[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(input, left, right);
    }

    public static void merge(int[] input, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                input[k++] = left[i++];

            } else {
                input[k++] = right[j++];
            }
        }
        while (i < left.length) {
            input[k++] = left[i++];
        }
        while (j < right.length) {
            input[k++] = right[j++];
        }
    }
}
