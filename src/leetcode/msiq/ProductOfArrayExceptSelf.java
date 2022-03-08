package leetcode.msiq;

import java.util.Arrays;

class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        int[] nums1 = {1, 2, 3, 4};

        System.out.println(Arrays.toString(obj.productExceptSelf(nums1)));
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        return compute(0, nums, length, result);
    }

    public int[] compute(int index, int[] nums, int length, int[] result) {
        if (index > length - 1) {
            return result;
        }

        int count = 0;
        long product = 1L;
        while (count < length) {
            if (count != index) {
                product *= nums[count];
            }
            count++;
        }
        result[index] = (int) product;
        compute(index + 1, nums, length, result);

        return result;
    }

    public int[] productExceptSelfNXN(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            long product = 1L;
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = (int) product;
        }

        return result;
    }
}