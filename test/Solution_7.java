import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution_7 {
	static Set<String> set = new HashSet<>();
	static int[] dp;
	static String word;
	static int n;
	
	public static int dfs(int index) {
		if(index == n) {
			return  dp[n] = 0;
		}
		
		if(dp[index] != -1)
			return dp[index];
		
		dp[index] = Integer.MAX_VALUE;
		
		for(int i = 5; i > 0; i--) {
			if(index + i <= n && set.contains(word.substring(index, index + i)))
					dp[index] = Math.min(dp[index], dfs(index + i) + 1);
		}
		
		return dp[index];
	}
	
	public static int solution(String[] strs, String t) {
		n = t.length();
		dp = new int[n + 1];
		word = t;
		Arrays.fill(dp, -1);
		set.clear();
		
		for(int i = 0; i < strs.length; i++) {
			set.add(strs[i]);
		}
		
		dfs(0);
		return dp[n ] != 0 ? -1 : dp[0];
	}
}