/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public static int maxProfit(int[] prices) {
        int max_profit = 0;
        //notice the difference between i's and j's endpoint
        for(int i=0; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++){
                int tmp= prices[j]-prices[i];
                max_profit = (tmp>max_profit)?tmp:max_profit;
            }
        }
        return max_profit;
    }
}
// @lc code=end

