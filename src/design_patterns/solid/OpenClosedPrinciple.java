package design_patterns.solid;

import java.util.Arrays;

/**
 * Open Closed Principle -
 * Objects or entities  should be open for extension but closed for modification
 */
interface ValueComparator {
    int compare(int value1, int value2);
}

class AscendingComparator implements ValueComparator {
    @Override
    public int compare(int value1, int value2) {
        return value1 - value2;
    }
}

class DescendingComparator implements ValueComparator {
    @Override
    public int compare(int value1, int value2) {
        return value2 - value1;
    }
}

class Sort {
    // Closed for Modification
    public static void sort(int[] nums, ValueComparator comparator) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (comparator.compare(nums[i], nums[j]) < 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}

class NaiveSortMethod {
    public static void sortAscendingOrder(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void sortDescendingOrder(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 5};
        //        NaiveSortMethod.sortAscendingOrder(nums);
        //        System.out.println(Arrays.toString(nums));
        //        NaiveSortMethod.sortDescendingOrder(nums);
        //        System.out.println(Arrays.toString(nums));

        Sort.sort(nums, new AscendingComparator());
        System.out.println(Arrays.toString(nums));
        Sort.sort(nums, new DescendingComparator());
        System.out.println(Arrays.toString(nums));
    }
}
