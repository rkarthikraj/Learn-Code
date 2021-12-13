package ac.sort;

import java.util.Arrays;

public class MergeSort {
    public static void conquer(int[] arr, int start, int mid, int end) {
        int[] merge = new int[(end - start) + 1];
        int index1 = start;
        int index2 = mid + 1;
        int x = 0;

        while (index1 <= mid && index2 <= end) {
            if (arr[index1] <= arr[index2]) {
                merge[x++] = arr[index1++];
            } else {
                merge[x++] = arr[index2++];
            }
        }

        while (index1 <= mid) {
            merge[x++] = arr[index1++];
        }

        while (index2 <= end) {
            merge[x++] = arr[index2++];
        }

        for (int i = 0, j = start; i < merge.length; i++, j++) {
            arr[j] = merge[i];
        }
    }

    public static void divide(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        divide(arr, start, mid);
        divide(arr, mid + 1, end);

        conquer(arr, start, mid, end);
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        int size = arr.length;
        divide(arr, 0, size - 1);

        System.out.println(Arrays.toString(arr));
    }
}
