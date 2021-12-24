class Solution {
	public static int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][2];
		//dp[i][0] means the maximum amount of profits earned with stock on hands
		//dp[i][1] means the maximum amount of profits earned with cash (without stock) on hands
		dp[0][0] = 0 - prices[0];
		dp[0][1] = 0;
		for(int i=1; i<prices.length; i++){
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
			dp[i][1] = Math.max(dp[i-1][0]+prices[i], dp[i-1][1]);
		}
		return dp[prices.length-1][1];
	}
	public static void main(String[] args) {
		int[] prices = new int[]{1,2,3,4,5};
		System.out.println(maxProfit(prices));
	}
}