class Solution_2 {
    public boolean solution(int[] arr) {
        boolean answer = true;
        int[] num = new int[1000001];
        int max = 0, count = 0;
        
        for(int i = 0; i < arr.length; i++) {
        	if(num[arr[i]] == 1) {
        		answer = false;
        		return answer;
        	}
        	
        	if(max < arr[i])
        		max = arr[i];
        	
        	num[arr[i]]++;
        }
        
        for(int i = 1; i <= arr.length; i++) {
        	if(num[i] == 1)
        		count++;
        }
        
        if(count != max) {
        	answer = false;
        }
        
        return answer;
    }
}