import java.util.Arrays;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        //dp[i] represents: 
        //  the length of the longest increasing sub-sequence ENDING with nums[i]
        //ATTENTION: what if dp[i] represents:
        //  the length of the longest increasing sub-sequence NOT NECESSARILY ENDING nums[i] 
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int current=0; current<nums.length; current++){
            for(int i=0; i<current; i++){
                dp[current] = (nums[current]>nums[i]) ? Math.max(dp[current], dp[i]+1):dp[current];
            }
            res = (dp[current]>res)?dp[current]:res;
        }
        return res;
    }
}
// @lc code=end

