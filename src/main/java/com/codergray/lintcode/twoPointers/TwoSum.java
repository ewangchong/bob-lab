package com.codergray.lintcode.twoPointers;

/**
 * Created by cwang on 4/20/17.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int[] result = new int[2];
        if (nums == null || nums.length < 2)
            return result;

        int i = 0;
        int j = 1;
        while (nums[i] + nums[j] < target) {
            j++;
        }

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }

            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 9, 21};
        TwoSum ts5 = new TwoSum();
        int[] rs = ts5.twoSum(nums, 11);
        for (int i = 0; i < rs.length; i++) {
            System.out.println(rs[i]);
        }

    }
}
