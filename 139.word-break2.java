import java.util.*;

class Solution {
	public static boolean wordBreak(String s, List<String> wordDict) {
		// dp[i] means s.substring(0, i+1) wordBreak is true
		boolean[] dp = new boolean[s.length()];
		// this List stores i when:( dp[i]=true)
		List<Integer> prevs = new ArrayList<Integer>();
		// a flag for judgeing whether s has a first word
		boolean hasPrev = false;
		// this variable represents the possible length of first word
		// it will be either 20 (one word's maximum length, accordning to the problem description) 
		// or the String(s)'s length
		int longestFirst = (21 < s.length())? 21:s.length();
		// find all possible first words, 
		//recording the first possible ending index in List<Integer> prevs
		for (int i = 0; i < longestFirst; i++) {
			if (wordDict.contains(s.substring(0, i + 1))) {
				hasPrev = true;
				dp[i] = true;
				prevs.add(i);
			}
		}
		//if it cannot find a first word, then return false
		if(!hasPrev) return false;
		//the dp process
		for(int i=0; i<s.length(); i++){
			if(dp[i]){}
			else{
				//iterate from the last to the first index in List<Integer> prevs
				//if s.substring(prev+1, i+1) is in the Dictionary
				//   add i in prevs and set dp[i] true
				//this part should be a method itself (instead of in the wordBreak method)
				ListIterator<Integer> iter = prevs.listIterator(prevs.size());
				while(iter.hasPrevious()){
					int prev = iter.previous();
					System.out.println("last word's index: "+prev + "; debuggin i+1:" + (i+1));
					if((i>prev) && wordDict.contains(s.substring(prev+1, i+1))){
						prevs.add(i);
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[s.length()-1];
	}
}