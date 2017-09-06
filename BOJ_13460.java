import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_13460 {
	static int N, M;
	static Stack<Character> stack = new Stack<>();
	
	public static boolean[] move(char[][] maze, int index) {
		boolean[] ending = new boolean[2]; // 0 happy 1 sad 
		stack.clear();
		
		switch(index) {
		case 0://오른
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(maze[i][j] == 'R' || maze[i][j] == 'B') {
						stack.push(maze[i][j]);
						maze[i][j] = '.';
					}else if(!stack.isEmpty()){
						if(maze[i][j] == 'O') {
							if(stack.size() == 2 || stack.peek() == 'B') {
								ending[1] = true;
								return ending;
							}else {
								ending[0] = true;
								return ending;
							}
						}else if(maze[i][j] == '#') {
							int size = stack.size();
							for(int k = 1; k <= size; k++) {
								maze[i][j - k] = stack.pop();
							}
						}
					}
				}
			}
			break;
		case 1://위
			for(int j = 0; j < M; j++) {
				for(int i = N - 1; i >= 0; i--) {
					if(maze[i][j] == 'R' || maze[i][j] == 'B') {
						stack.push(maze[i][j]);
						maze[i][j] = '.';
					}else if(!stack.isEmpty()){
						if(maze[i][j] == 'O') {
							if(stack.size() == 2 || stack.peek() == 'B') {
								ending[1] = true;
								return ending;
							}else {
								ending[0] = true;
								return ending;
							}
						}else if(maze[i][j] == '#') {
							int size = stack.size();
							for(int k = 1; k <= size; k++) {
								maze[i + k][j] = stack.pop();
							}
						}
					}
				}
			}
			
			break;
		case 2://왼
			for(int i = 0; i < N; i++) {
				for(int j = M - 1; j >= 0; j--) {
					if(maze[i][j] == 'R' || maze[i][j] == 'B') {
						stack.push(maze[i][j]);
						maze[i][j] = '.';
					}else if(!stack.isEmpty()){
						if(maze[i][j] == 'O') {
							if(stack.size() == 2 || stack.peek() == 'B') {
								ending[1] = true;
								return ending;
							}else {
								ending[0] = true;
								return ending;
							}
						}else if(maze[i][j] == '#') {
							int size = stack.size();
							for(int k = 1; k <= size; k++) {
								maze[i][j + k] = stack.pop();
							}
						}
					}
				}
			}
			
			break;
		case 3://아래
				for(int j = 0; j < M; j++) {
					for(int i = 0; i < N; i++) {
					if(maze[i][j] == 'R' || maze[i][j] == 'B') {
						stack.push(maze[i][j]);
						maze[i][j] = '.';
					}else if(!stack.isEmpty()){
						if(maze[i][j] == 'O') {
							if(stack.size() == 2 || stack.peek() == 'B') {
								ending[1] = true;
								return ending;
							}else {
								ending[0] = true;
								return ending;
							}
						}else if(maze[i][j] == '#') {
							int size = stack.size();
							for(int k = 1; k <= size; k++) {
								maze[i - k][j] = stack.pop();
							}
						}
					}
				}
			}
			break;
		}
		
		return ending;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		char[][] map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		Queue<char[][]> q = new LinkedList<>();
		Queue<Integer> qc = new LinkedList<>();
		Queue<Integer> last = new LinkedList<>();
		
		q.add(map);
		qc.add(0);
		last.add(-1);
		int result = 11;
		
		while(!q.isEmpty() && qc.peek() < 10) {
			char[][] maze = q.poll();
			int count = qc.poll();
			int index = last.poll();
			
			for(int i = 0; i < 4; i++) {
				if(index == i)
					continue;
				
				char[][] temp = new char[N][M];
				
				for(int a = 0; a < N; a++)
					temp[a] = Arrays.copyOf(maze[a], M);
				
				boolean[] ending = move(temp, i);// 0 happy 1 sad 
				
				if(ending[0] && !ending[1]) {
					q.clear();
					result = count + 1;
					break;
				}else if(!ending[0] && ending[1]) {
					continue;
				}else if(!ending[0] && !ending[1]) {
					q.add(temp);
					qc.add(count + 1);
					last.add(i);
				}
			}
		}
		
		if(result == 11)
			System.out.println(-1);
		else
			System.out.println(result);
	}
}
