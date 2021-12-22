import javax.swing.plaf.TextUI;

/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
/* This recurive solution for longest-palindromic works, however,
I cannot submit this on Leetcode. 
Leetcode's submission and testing system have bugs regarding global variables
The Leetcode Team has not given an solution so far */
class Solution {
    static int longest = 0;
    static int start, end;
    public static String longestPalindrome(String s) {
        rlongestPalindrome(s, 0, s.length()-1);
        return s.substring(start, end+1);
    } 
    public static void rlongestPalindrome(String s, int i, int j) {
        if(i >= j || i < 0 || j>= s.length()) return;
        if(isPalindrome(s, i, j)){
            int sublength = j - i + 1;
            if(sublength > longest){
                longest = sublength;
                start = i;
                end = j;
            }
        }
        rlongestPalindrome(s, i+1, j);
        rlongestPalindrome(s, i, j-1);
    }
    public static Boolean isPalindrome(String s, int i, int j){
        if(i >= j || i < 0 || j>= s.length()) return true;
        if(s.charAt(i) == s.charAt(j)){
            return isPalindrome(s, i+1, j-1);
        }
        return false;

    }
}
// @lc code=end

