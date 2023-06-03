package com.codergray.lintcode.binarysearch;

/**
 * Created by cwang on 3/8/17.
 */
public class RotatedSortedArray {
    public static void main(String[] args) {
        RotatedSortedArray array = new RotatedSortedArray();
        int index = array.findMin(new int[]{-9,-8,-7,-6,-5,-4,-3,-2,-1,-10});
        System.out.println(index);
    }

    public int findMin(int[] nums) {
        // write your code here
        int start = 0;
        int end = nums.length-1;
        if (end == 0) {
            return nums[0];
        }
        if (end == 1) {
            return nums[1] > nums[0] ? nums[0] : nums[1];
        }

        if (nums[0] < nums[end]){
            return nums[0];
        }

        if(nums[end] < nums[end-1]){
            return nums[end];
        }

        int mid = start + (end - start) / 2;
        while (start < mid && mid < end) {
            if (nums[mid] < nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
            mid = start + (end - start) / 2;
            System.out.println(start+" "+mid+" "+end);
        }
        return -1;
    }
}
