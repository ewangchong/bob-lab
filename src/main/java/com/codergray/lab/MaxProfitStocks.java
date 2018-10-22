package com.codergray.lab;

public class MaxProfitStocks {
    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{1, 2, 100, 3, 99}));
    }
    
    public static int maxProfit(int[] prices){
        int max = 0;
        int[] maxPrices = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            if(prices[i] > max){
                max = prices[i];
                maxPrices[i] = max;
            }
            maxPrices[i] = max;
        }
        
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit += maxPrices[i] - prices[i];
        }
        return profit;
    }
}
