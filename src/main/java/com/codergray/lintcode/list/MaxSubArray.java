package com.codergray.lintcode.list;

public class MaxSubArray {
	public int maxSubArray(int[] nums) {
		// write your code
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int sum = 0;
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > max && maxIndex >=minIndex) {
				max = sum;
				maxIndex=i;
			}

			if (sum < min && maxIndex >minIndex) {
				min = sum;
				minIndex=i;
			}
			System.out.println(min + " " + max);
		}

		return max - min;
	}

	public static void main(String[] args) {
		MaxSubArray msa = new MaxSubArray();
		
		System.out.println(msa.maxSubArray(new int[]{-1,-2,-3,-100,-1,-5,-6}));
	}
}
