package alogs.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] data = {-1, 0, 10, 11, 3, 5, 2, 21, 9, 8, 6};
        mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
        System.out.println("Sorted");
    }

    public static void mergeSort(int[] data, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }

    public static void merge(int[] data, int start, int mid, int end) {
        // Build temp array to avoid modifying the original contents.
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (data[i] <= data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = data[i++];
        }

        while (j <= end) {
            temp[k++] = data[j++];
        }

        for (i = start; i <= end; ++i) {
            data[i] = temp[i - start];
        }
    }
}
