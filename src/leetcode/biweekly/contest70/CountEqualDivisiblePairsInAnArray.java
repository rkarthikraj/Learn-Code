package leetcode.biweekly.contest70;

class CountEqualDivisiblePairsInAnArray {
    public static void main(String[] args) {
        CountEqualDivisiblePairsInAnArray obj = new CountEqualDivisiblePairsInAnArray();
        int[] nums1 = {3, 1, 2, 2, 2, 1, 3};
        int k1 = 2;
        System.out.println(obj.countPairs(nums1, k1));

        int[] nums2 = {1,2,3,4};
        int k2 = 1;
        System.out.println(obj.countPairs(nums2, k2));
    }

    public int countPairs(int[] nums, int k) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] == nums[j]) {
                        int value = i * j;
                        if ((value % k) == 0) {
                            result++;
                        }
                        // System.out.println(i + " - " + j);
                    }
                }
            }
        }

        return result;
    }
}