/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        int i = 0,j = 0;
        char prev = '!';
        while(i<slen && j<plen){
            if(s.charAt(i)==p.charAt(j) || (p.charAt(j)=='.' )){
                prev = p.charAt(j);
                i++;
                j++;
            }else if((j+1<plen) && p.charAt(j+1)=='*'){
                j = j + 2;
            }else if((p.charAt(j)=='*') && (prev==s.charAt(i) || prev=='.')){
                i++;
            }else{
                return false;
            }
        }
        if((j==plen-1 && p.charAt(j)=='*') ||(j==plen-2 && p.charAt(j+1)=='*')){
            return true;
        }else{
            return false;
        }
    }
}
// @lc code=end

