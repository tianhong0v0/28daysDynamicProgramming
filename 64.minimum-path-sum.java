import java.util.Arrays;

/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] min_dist = new int[row+1][col+1];
        Arrays.fill(min_dist[0], Integer.MAX_VALUE);
        for(int i=1; i<=row; i++){
            min_dist[i][0] = Integer.MAX_VALUE;
        }
        for(int i=1; i<=row; i++){
            for(int j=1; j<=col; j++){
                if (i==1 && j==1){
                    min_dist[i][j] = grid[i-1][j-1];
                }else{
                    min_dist[i][j] = grid[i-1][j-1] + Math.min(min_dist[i-1][j], min_dist[i][j-1]);
                }
            }
        }
        return min_dist[row][col];
    }
}
// @lc code=end

