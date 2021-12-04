import java.util.Scanner;

/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
public class Solution {
    public static int maxProfit(int[] prices) {
        int counter = 0;
        int max = 0;
        for(int i=0; i<prices.length-1; i++){
            int tmp_profit = 0;
            int profit = 0;
            for(int j=i+1; j<prices.length; j++){
                int tmp = prices[j] - prices[j-1];
                if(tmp>0 && counter<2){
                    profit = profit + tmp;
                    counter++;
                }
                else if(counter>=2){
                    tmp_profit = (profit>tmp_profit)?profit:tmp_profit;
                    tmp = prices[j] - prices[i];
                    profit = tmp;
                    counter = 1;
                }
            }
            max = (profit>max)?profit:max;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] prices = new int[]{};
        System.out.println(maxProfit(prices)); 
    }
}

// @lc code=end

