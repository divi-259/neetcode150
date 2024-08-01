/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
*/

public int maxProfit(int[] prices) {
        int minsofar = prices[0];

        int ans = Integer.MIN_VALUE;
        for(int i=1; i<prices.length; i++) {
            ans = Math.max(ans, prices[i]-minsofar);
            minsofar = Math.min(minsofar, prices[i]);
        }

        return ans>0 ? ans : 0;
    }