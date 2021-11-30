/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for(int i = 1; i<= n; i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r; 
    }
}
// @lc code=end

