class Solution_4 {
    public int solution(int [][]board) {
        int answer = 0, len = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n][m];
       
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if(board[i][j] == 1){
        			dp[i][j] = 1;
        			
        			if(i > 0 && j > 0)
        				dp[i][j] += Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
        		}
        		
        		len = Math.max(len, dp[i][j]);
        	}
        }
        
       answer = len * len;
       return answer;
    }
}