package leetcode.others;

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        SearchInRotatedSortedArrayII obj = new SearchInRotatedSortedArrayII();
        //        int[] nums1 = {4, 5, 6, 6, 7, 0, 1, 2, 4, 4};
        //        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        //        int[] nums3 = {2, 5, 6, 0, 0, 1, 2};
        int[] nums4 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};


        //        System.out.println(obj.search(nums1, 0));
        //        System.out.println(obj.search(nums2, 3));
        //        System.out.println(obj.search(nums3, 5));
        System.out.println(obj.search(nums4, 2));
    }

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return true;
            }

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
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

        return false;
    }

    //    public boolean searchWorstApproach(int[] nums, int target) {
    //        int length = nums.length;
    //
    //        int left = 0;
    //        int right = length - 1;
    //
    //        Arrays.sort(nums);
    //
    //        System.out.println("Left: " + left + ", Right: " + right);
    //        while (left <= right) {
    //            int mid = left + (right - left) / 2;
    //            if (target == nums[mid]) {
    //                return true;
    //            } else if (target > nums[mid]) {
    //                left = mid + 1;
    //            } else {
    //                right = mid - 1;
    //            }
    //        }
    //
    //        return false;
    //    }
}
