import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_12100 {
	static int N;
	static int result = 0;
	static Stack<Integer> stack = new Stack<>();
	
	public static int[][] move(int[][] board, int index) {
		int[][] temp = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				temp[i][j] = board[i][j];
			}
		}
		
		//0 오른 1 위 2 왼 3 아래
		switch(index) {
		case 0: //오른
			for(int i = 0; i < N; i++) {
				int num = -1;
				
				for(int j = N - 1; j >= 0; j--) {
					if(temp[i][j] != 0 && stack.isEmpty())
						stack.add(temp[i][j]);
					else if(temp[i][j] != 0 && stack.peek() == temp[i][j] && num != stack.peek()) {
						stack.push(stack.pop() + temp[i][j]);
						num = stack.peek();
					}else if(temp[i][j] != 0 && stack.peek() == temp[i][j] && num == stack.peek()) {
						stack.push(temp[i][j]);
						num = -1;
					}else if(temp[i][j] != 0 && stack.peek() != temp[i][j]) {
						stack.push(temp[i][j]);
						num = -1;
					}
					
					temp[i][j] = 0;
				}
				
				for(int j = N - stack.size(); j < N; j++) {
					temp[i][j] = stack.pop();
				}
			}
			break;
			
		case 1: //위
			for(int j = 0; j < N; j++) {
				int num = -1;
				
				for(int i = 0; i < N; i++) {
					if(temp[i][j] != 0 && stack.isEmpty())
						stack.add(temp[i][j]);
					else if(temp[i][j] != 0 && stack.peek() == temp[i][j] && num != stack.peek()) {
						stack.push(stack.pop() + temp[i][j]);
						num = stack.peek();
					}else if(temp[i][j] != 0 && stack.peek() == temp[i][j] && num == stack.peek()) {
						stack.push(temp[i][j]);
						num = -1;
					}else if(temp[i][j] != 0 && stack.peek() != temp[i][j]) {
						stack.push(temp[i][j]);
						num = -1;
					}
					
					temp[i][j] = 0;
				}
				
				for(int i = stack.size() - 1; i >= 0; i--) {
					temp[i][j] = stack.pop();
				}
			}
			break;
			
		case 2: // 왼
			for(int i = 0; i < N; i++) {
				int num = -1;
				
				for(int j = 0; j < N; j++) {
					if(temp[i][j] != 0 && stack.isEmpty())
						stack.add(temp[i][j]);
					else if(temp[i][j] != 0 && stack.peek() == temp[i][j] && num != stack.peek()) {
						stack.push(stack.pop() + temp[i][j]);
						num = stack.peek();
					}else if(temp[i][j] != 0 && stack.peek() == temp[i][j] && num == stack.peek()) {
						stack.push(temp[i][j]);
						num = -1;
					}else if(temp[i][j] != 0 && stack.peek() != temp[i][j]) {
						stack.push(temp[i][j]);
						num = -1;
					}
					
					temp[i][j] = 0;
				}
				
				for(int j = stack.size() - 1; j >= 0; j--) {
					temp[i][j] = stack.pop();
				}
			}
			break;
			
		case 3: // 아래
			for(int j = 0; j < N; j++) {
				int num = -1;
				
				for(int i = N - 1; i >= 0; i--) {
					if(temp[i][j] != 0 && stack.isEmpty())
						stack.add(temp[i][j]);
					else if(temp[i][j] != 0 && stack.peek() == temp[i][j] && num != stack.peek()) {
						stack.push(stack.pop() + temp[i][j]);
						num = stack.peek();
					}else if(temp[i][j] != 0 && stack.peek() == temp[i][j] && num == stack.peek()) {
						stack.push(temp[i][j]);
						num = -1;
					}else if(temp[i][j] != 0 && stack.peek() != temp[i][j]) {
						stack.push(temp[i][j]);
						num = -1;
					}
					
					temp[i][j] = 0;
				}
				
				for(int i = N - stack.size(); i < N; i++) {
					temp[i][j] = stack.pop();
				}
			}
			break;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				result = Math.max(result, temp[i][j]);
			}
		}
		return temp;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		Queue<int[][]> q = new LinkedList<>();
		Queue<Integer> qc = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			String[] strs = br.readLine().split(" ");
			
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		q.add(board);
		qc.add(0);
		
		while(!q.isEmpty() && qc.peek() < 5) {
			for(int i = 0; i < 4; i++) {
				q.add(move(q.peek(), i));
				qc.add(qc.peek() + 1);
			}
			
			q.poll();
			qc.poll();
		}
		
		System.out.println(result);
	}
}