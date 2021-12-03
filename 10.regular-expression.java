import java.util.Scanner;

class Solution {
	public static boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		//initialize dp[0][0] = true
		dp[0][0] = true;
		//initialize some '*' elements in dp[0][] = true
		//for example: 
		//	if p == "c*a*"
		//	then dp[0][1+1] and dp [0][3+1] = true
		if (p.length() >= 2){
			int l = 0;
			int r = 1;
			while(r-l<=1 && r<p.length()){
				if(p.charAt(r)=='*'){
					dp[0][r+1] = true;
					l = r + 1;
					r = l + 1;
				}else{
					r++;
				}
				
			}
		}
		//the dynamic programming process
		for(int i=1; i<s.length()+1; i++){
			for(int j=1; j<p.length()+1; j++){
				if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
					dp[i][j] = dp[i-1][j-1];
				}else if(p.charAt(j-1)=='*'){
					if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.'){
						dp[i][j] = dp[i][j-1] || dp[i][j-2] || dp[i-1][j];
					}else{
						dp[i][j] = dp[i][j-2];
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}
	public static void main(String[] args) {
		//input test cases
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		System.out.print("Enter a string: ");  
		String s= sc.nextLine();  
		System.out.print("Enter a pattern: ");  
		String p= sc.nextLine(); 
		System.out.println(isMatch(s, p));
	}
}