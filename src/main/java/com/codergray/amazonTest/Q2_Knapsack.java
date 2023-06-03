package com.codergray.amazonTest;

public class Q2_Knapsack extends Q2 {

	/***
	 * Turn this problem into a 0-1 knapsack problem: whether there exists a
	 * subset of numbers in the list whose sum is half of the total sum.
	 * 
	 * Constraints: The space complexity is O(VN), so for long list of numbers, it may cause out of memeory error.
	 * 
	 * @param length
	 * @param half
	 * @param v
	 * @return
	 */
	protected boolean isEuqationExists(int length, int[] numbers) {
		// if a+b-c=d-e+f, then a+b+e=d+f+c, which means
		// 1. the sum of absolute value of the numbers must be even
		long sum = 0;
		for (int i = 0; i < length; i++) {
			sum += numbers[i];
		}
		if (sum % 2 == 1)
			return false;

		// 2. if there is a number whose abs value is larger than half of total
		// sum, the answer must be NO
		int half = (int) (sum / 2);
		for (int i = 0; i < length; i++) {
			if (numbers[i] > half)
				return false;
		}

		// Turn this problem into a 0-1 knapsack problem: whether there exists a
		// subset of numbers in the list whose sum is half of the total sum.
		
		System.out.println((long)length*(half+1) +" " + Runtime.getRuntime().maxMemory());
		if((long)length*(half+1)>Runtime.getRuntime().maxMemory()){
			logger.severe("The list is too long");
			return false;
		};
		
		boolean[][] isSum = new boolean[length][half + 1];
		// Initialize
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < half + 1; j++) {
				if (i == 0 && (j == 0 || j == numbers[0]))
					isSum[i][j] = true;
				else
					isSum[i][j] = false;
			}
		}
		// Set all the possible sum of subsets to true.
		for (int i = 1; i < length; i++) {
			for (int j = 0; j <= half; j++) {
				if (j >= numbers[i]) {
					isSum[i][j] = isSum[i - 1][j]
							|| isSum[i - 1][j - numbers[i]];
				} else {
					isSum[i][j] = isSum[i - 1][j];
				}
			}
		}
		return isSum[length - 1][half];
	}
}
