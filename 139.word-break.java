/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 * 33 / 45 test cases passed.
 * Status: Time Limit Exceeded
 * 
 * Recursive Solution Written by TianTian, 
 * this algorithm works fine, 
 * I had already: figured out the Recursive Formula
 * I need to: convert this recursive method to Dynamic Programming
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        //longestWordLen represents that the length of the longest word is less than 20
        //THIS IS A MAGIC NUMBER
        // 1 <= wordDict[i].length <= 20
        int longestWordLen = 20;
        return judge_rest(s, wordDict, 0, longestWordLen);
    }

    //recursive method for judgeing whether a string can be breaked into dict words
    //1. find all possible first words in this string
    //2. record the first word's ending index in a List (nextIndex)
    //3. THIS IS THE RECURSIVE PART: judge the rest of the string 
    public static boolean judge_rest(String s, List<String> wordDict, int beginIndex, int longestWordLen) {
        boolean hasBeginWord = false;
        //if this string cannot match a single word at the begining, just return false
        int endIndex = ((beginIndex+longestWordLen) < s.length()) ? (beginIndex+longestWordLen):s.length(); 
        List<Integer> nextIndex = new ArrayList<Integer>();
        for(int i=beginIndex; i<endIndex; i++){
            if(wordDict.contains(s.substring(beginIndex, i+1))){
                hasBeginWord = true;
                //if i matches the last index of s, means that all previous words match
                if(i == s.length()-1){
                    return true;
                }
                nextIndex.add(i+1);
            }
        }
        boolean rest = false;
        for(Integer next: nextIndex){
            if(judge_rest(s, wordDict, next, longestWordLen)){ rest = true; }
        }
        return (hasBeginWord && rest);
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<String>();
        dict.add("cats");
        dict.add("dog");
        dict.add("sand");
        dict.add("and");
        dict.add("cat");
        String s = "catsandog";
        System.out.println(wordBreak(s, dict));

    }
}
// @lc code=end

