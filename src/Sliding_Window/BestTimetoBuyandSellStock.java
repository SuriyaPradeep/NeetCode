package Sliding_Window;
/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
Example 1
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BestTimetoBuyandSellStock {
    /*
    Here we initialize two variables maxProfit and lowestPrices which will keep of maximum profit and lowest price encountered so far
    Iterate through the array check whether the current price is lower than lowestPrice if yes swap them
    calculate profit ie current price - lowestPrice
    if current profit is larger than maxProfit swap
    At end return maxProfit
     */
    public int maxProfit(int[] prices) {
        int maxProfit=Integer.MIN_VALUE,lowestPrice=Integer.MAX_VALUE;
        for(int price:prices){
            lowestPrice=Math.min(lowestPrice,price);
            maxProfit=Math.max(maxProfit,price-lowestPrice);
        }
        return maxProfit;
    }
}
