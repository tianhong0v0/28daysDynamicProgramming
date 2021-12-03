public class Solution {
	public static int maxProfit(int[] prices) {
		int min_price = Integer.MAX_VALUE;
		int max_profit = 0;
		for(int i=0; i<prices.length; i++){
			int tmp = prices[i] - min_price;
			max_profit = (tmp>max_profit) ? tmp:max_profit;
			min_price = (prices[i]<min_price) ? prices[i]:min_price;
		}
		return max_profit;
	}
	public static void main(String[] args) {
		int[] prices = new int[]{};
		System.out.println(maxProfit(prices));
	}
}
