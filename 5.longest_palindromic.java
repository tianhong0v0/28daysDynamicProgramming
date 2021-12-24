class Solution {
	public static String longestPalindrome(String s) {
		//if the string's length is 1, then just return the string
		int len = s.length();
		if(len < 2) return s;

		char[] c = s.toCharArray();

		//dp[i][j] represents whether s.substring(i, j+1) is a palindrome
		boolean[][] dp = new boolean[len][len];

		//initialize beginIndex and the shortest palindromic substring's length
		int beginIndex = 0;
		int substringLen = 1;

		//every single character substring is a palindrome
		//thus, initialize every dp[i][i] to true
		for(int i=0; i<len; i++){
			dp[i][i] = true;
		}

		//decide whether s(i, j) is a palindrome
		for(int i=len-1; i>=0; i--){
			for(int j=i+1; j<len; j++){
				if(c[i] == c[j]){
					//Think about this: what is the "recursive formulation" used here?
					if(j-i == 1){
						dp[i][j] = true;
					}else{
						dp[i][j] = dp[i+1][j-1];
					}
					//keep track of the longest palindromic substring
					if(dp[i][j] == true && j-i+1 >= substringLen ){
							substringLen = j-i+1;
							beginIndex = i;
					}
				}else{
					dp[i][j] = false;
				}
			}
		}
		return s.substring(beginIndex, beginIndex+substringLen);
	}
	public static void main(String[] args) {
		String s = "aacabdkacaa";
		System.out.println(longestPalindrome(s));
	} 	
}
