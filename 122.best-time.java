public class Solution {
	/* trying to solve this using dynamic programming makes thing complicated 
	must figure out the REAL or CORE logic of a problems before solving it blindedly */

	public int maxProfit(int[] prices) {
		int total = 0;
		for(int i=1; i<prices.length; i++){
			int tmp = prices[i]-prices[i-1];
			if(tmp>0){
				total = total + tmp;
			}
		}
		return total;
	}
}
