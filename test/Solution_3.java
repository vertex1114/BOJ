class Solution_3 {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        int x = v[0][0] + v[1][0] + v[2][0];
        int y = v[0][1] + v[1][1] + v[2][1];
        boolean flagX = true;
        boolean flagY = true;
        
        for(int i = 0; i < 3; i++) {
        	for(int j = 1; j < 3; j++) {
        		if(v[i][0] == v[j][0] && flagX) {
        			x = x - v[i][0] - v[j][0];
        			flagX = false;
        		}
        		
        		if(v[i][1] == v[j][1] && flagY) {
        			y = y - v[i][1] - v[j][1];
        			flagY = false;
        		}
        	}
        }
        
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}