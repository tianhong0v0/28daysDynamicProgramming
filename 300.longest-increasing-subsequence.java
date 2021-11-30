/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[][] dp = new int[nums.length][nums.length];
        int[] rowmax = new int[nums.length];
        rowmax[0] = 1;
        for(int i=0; i<nums.length; i++){
            dp[i][i] = 1;
        }

        for(int row=1; row<nums.length; row++){
            int current = nums[row];
            int tmpmax = 1;
            for(int i=0; i<row; i++){
                int prev = nums[i];
                if (current > prev){
                    dp[row][i] = rowmax[i] + 1;
                    tmpmax = (dp[row][i] > tmpmax) ? dp[row][i]:tmpmax;
                }else{
                    dp[row][i] = 1;
                }
            }
            rowmax[row] = tmpmax;
        }
        int result = 1;
        for(int r: rowmax){
            result = (r > result) ? r:result;
        }
        return result;
    }
}
// @lc code=end

