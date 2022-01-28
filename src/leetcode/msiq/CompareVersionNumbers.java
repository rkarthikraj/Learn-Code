package leetcode.msiq;

import java.util.Arrays;

class CompareVersionNumbers {
    public static void main(String[] args) {
        CompareVersionNumbers obj = new CompareVersionNumbers();
        String version1 = "0.1", version2 = "1.0";
        System.out.println(obj.compareVersion(version1, version2));
    }

    public int compareVersion(String version1, String version2) {
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");

        int v1Len = version1Arr.length;
        int v2Len = version2Arr.length;
        int length = 0;

        if (v1Len < v2Len) {
            length = v2Len;
        } else {
            length = v1Len;
        }

        int[] v1 = new int[length];
        int[] v2 = new int[length];

        for (int i = 0; i < v1Len; i++) {
            v1[i] = Integer.parseInt(version1Arr[i]);
        }

        for (int i = 0; i < v2Len; i++) {
            v2[i] = Integer.parseInt(version2Arr[i]);
        }

        int index = 0;
        while(index < length) {
            int range = v1[index] - v2[index];
            if(range < 0) {
                return -1;
            } else if(range > 0) {
                return 1;
            }

            index++;
        }

        return 0;
    }

    public int compareVersionOptimize(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int n1 = nums1.length;
        int n2 = nums2.length;

        int length = Math.max(nums1.length, nums2.length);
        int i1, i2;

        for(int i = 0; i < length; i++){
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;

            if(i1 != i2){
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }
}