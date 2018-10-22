package com.codergray.lintcode.misc;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		int[] prices = new int[] { 10, 2, 93, 4, 6, 9, 11, 1, 22, 3, 99 };
		System.out.println(BestTimetoBuyandSellStock.maxProfit(prices));
		
		prices = new int[] { 4,1,2 };
		System.out.println(BestTimetoBuyandSellStock.maxProfit(prices));

	}

	public static int maxProfit(int[] prices) {
		int max = 0;

		if (prices.length == 0) {
			return 0;
		}

		if (prices.length == 1) {
			return 0;
		}

		int low = 0;
		int high = 0;
		int profit = 0;

		for (int i = 0; i < prices.length; i++) {
			profit = prices[i] - prices[low];

			if (prices[i] < prices[low]) {
				low = i;
			}

			if (prices[i] > prices[high]) {
				high = i;
			}

			if (high > low) {
				profit = prices[high] - prices[low];
				if (profit > max)
					max = profit;
			}else{
				high = low;
			}
		}
		return max;

	}

}
