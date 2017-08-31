class Solution_5 {
    int solution(int[][] land) {
    	int n = land.length;
    	int m = land[0].length;
    	int[][] cache = new int[n][m];
    	
    	for(int i = 0; i < n; i++) {
    		if(i == 0) {
    			cache[i][0] = land[i][0];
    			cache[i][1] = land[i][1];
    			cache[i][2] = land[i][2];
    			cache[i][3] = land[i][3];
    		}else {
    			cache[i][0] = land[i][0] + Math.max(cache[i - 1][1], Math.max(cache[i - 1][2], cache[i - 1][3]));
    			cache[i][1] = land[i][1] + Math.max(cache[i - 1][0], Math.max(cache[i - 1][2], cache[i - 1][3]));
    			cache[i][2] = land[i][2] + Math.max(cache[i - 1][0], Math.max(cache[i - 1][1], cache[i - 1][3]));
    			cache[i][3] = land[i][3] + Math.max(cache[i - 1][0], Math.max(cache[i - 1][1], cache[i - 1][2]));
    		}
    	}
    	
    	int answer = 0;
    	
    	for(int i = 0; i < 4; i++) {
    		if(answer < cache[n - 1][i])
    			answer = cache[n - 1][i];
    	}
        
        return answer;
    }
}