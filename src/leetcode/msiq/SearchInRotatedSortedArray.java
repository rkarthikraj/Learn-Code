package leetcode.msiq;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
Memory Usage: 38.3 MB, less than 73.28% of Java online submissions for Search in Rotated Sorted Array.
 */

class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {10, 1, 2, 3, 4, 5};
        int[] nums3 = {1, 2, 3, 4, 5};
        int target = 0;
        System.out.println(obj.searchOnePass(nums1, target));
        System.out.println(obj.searchOnePass(nums2, 7));
        System.out.println(obj.searchOnePass(nums3, 0));
    }

    public int searchOnePass(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // To get the smallest element in the rotated sorted array.
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int start = left;
        left = 0;
        right = nums.length - 1;

        // {4, 5, 6, 7, 0, 1, 2} target = 4, Start Index = 4
        // To identify which part of the array to be used for search.
        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}