package com.codergray.lintcode.twoPointers;

import java.util.Arrays;

/**
 * Created by cwang on 4/20/17.
 */
public class TwoSum5 {
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0, j = 1; j<nums.length; ) {
            int sum = nums[i] + nums[j];
            if (sum <= target) {
                count++;
                if(j==nums.length-1){
                    i++;
                    j=i+1;
                }else{
                    j++;
                }
            } else {
                i++;
                j = i + 1;
            }
        }

        return count;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 5, 9, 21};
        TwoSum5 ts5 = new TwoSum5();
        System.out.println(ts5.twoSum5(nums, 28));
    }
}
