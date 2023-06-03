package com.codergray.lintcode.binarysearch;

/**
 * Created by cwang on 3/6/17.
 */
public class Search {
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length < 3){
            for (int i = 0; i < nums.length; i++){
                if (nums[i] == target){
                    return i;
                }
            }
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = end / 2;
        if (target < nums[0] || target > nums[end]){
            return -1;
        }
        if (target == nums[0]){
            return 0;
        }
        int result = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[mid] == target && nums[mid - 1] < target){
                return mid;
            }
            if (nums[mid] >= target){
                end = mid;
                mid = start + (end - start) / 2;
            } else {
                start = mid;
                mid = start + (end - start) / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Search search = new Search();
        int index = search.binarySearch(new int[]{1, 3, 4, 5, 6, 8, 19, 23,33}, 8);
        System.out.println(index);
    }
}
