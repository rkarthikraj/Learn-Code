package alogs.sorting;

import java.util.Arrays;

public class QuickSort {
    public void qs(int[] inputArray) {
        int left = 0;
        int right = inputArray.length - 1;

        quickSort(inputArray, left, right);
        System.out.println(Arrays.toString(inputArray));
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = left;
        int i = left;
        int j = right;
        while (i < j) {
            while (i < right && arr[i] <= arr[pivot])
                i++;
            while (arr[j] > arr[pivot])
                j--;

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, pivot, j);
        return j;
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int[] a1 = {1, 2, 3};
        int[] a2 = {3, 2, 1};
        int[] a3 = {};
        int[] a4 = {3, 1, -1, 0, 2, 5};
        int[] a5 = {2, 2, 1, 1, 0, 0, 4, 4, 2, 2, 2};
        int[] a6 = {0};
        int[] a7 = {3, -2, -1, 0, 2, 4, 1};
        int[] a8 = {1, 2, 3, 4, 5, 6, 7};
        int[] a9 = {2, 2, 2, 2, 2, 2, 2};


        obj.qs(a1);
        obj.qs(a2);
        obj.qs(a3);
        obj.qs(a4);
        obj.qs(a5);
        obj.qs(a6);
        obj.qs(a7);
        obj.qs(a8);
        obj.qs(a9);
    }
}

// Intially i will be pivot which is first element of array
// j will be the last element of array
// i will search for element which are greater than pivot
// j will search for the element which are smaller than pivot

// Increment i until you find the element greater than pivot
// Decrement j until you find the element smaller than or equal to pivot
// Swap i and j
// Continue
// If i > j -> Dont swap i and j
// Swap j and pivot
// Now all the element in LHS are smaller than pivot and all the element in RHS are greater than pivot
