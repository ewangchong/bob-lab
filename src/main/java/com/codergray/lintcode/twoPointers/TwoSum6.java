package com.codergray.lintcode.twoPointers;

/**
 * Created by cwang on 4/20/17.
 */
public class TwoSum6 {
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int i = 0;
        int j = nums.length - 1;

        int iv = nums[i];
        int jv = nums[j];

        int count = 0;
        if (iv + jv == target) {
            count++;
        }

        while (i < j) {
            if (nums[i] + nums[j] == target) {
                if (nums[i] == iv && nums[j] == jv) {
                } else {
                    iv=nums[i];
                    jv=nums[j];
                    count++;
                }
                i++;
                j--;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 8, 9, 21};
        TwoSum6 ts = new TwoSum6();
        System.out.println(ts.twoSum6(nums, 10));
    }
}
