import java.util.Arrays;

/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][prices.length];
        for(int i=1; i<prices.length+1; i++){
            for(int j=i; j<prices.length; j++){
                dp[i][j] = Math.max(Math.max(dp[i][j-1],dp[i-1][j]),dp[i-1][i-1]+prices[j]-prices[i-1]);
            }
        }
        return dp[prices.length-1][prices.length-1];
    }
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }
}
// @lc code=end

