class Solution_6 {
	public int solution(int sticker[]) {
		int answer = 0;
		int n = sticker.length;
		int[][] cache = new int[n + 1][2];
		
		for(int i = 1; i <= n; i++) {
			if(i == n)
				break;
			
            cache[i][0] = Math.max(cache[i - 1][0], sticker[i - 1]);
            
            if(i >= 2)
            	cache[i][0] = Math.max(cache[i - 2][0] + sticker[i - 1], cache[i][0]);
        
            answer = Math.max(answer, cache[i][0]);
		}
		
		for(int i = 2; i <= n; i++) {
			cache[i][1] = Math.max(cache[i - 1][1], sticker[i - 1]);
            cache[i][1] = Math.max(cache[i - 2][1] + sticker[i - 1], cache[i][1]);
            
            answer = Math.max(answer, cache[i][1]);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
	}
}