import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14500 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int result = 0;
	
	public static void dfs(int y, int x, int count, int value) {
		if(count == 4) {
			result = Math.max(value, result);
			return;
		}
		
		value += map[y][x];
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= M || ny >= N || nx < 0 || ny < 0 || visited[ny][nx])
				continue;
			
			dfs(ny, nx, count + 1, value);
		}
		
		visited[y][x] = false;
	}
	
	public static void cross(int y, int x) {
		int count = 0, value = map[y][x];
		int min = Integer.MAX_VALUE;
		
		if(y + 1 < N) {
			count++;
			value += map[y + 1][x];
			min = Math.min(min, map[y + 1][x]);
		}
		
		if(x +  1 < M) {
			count++;
			value += map[y][x + 1];
			min = Math.min(min, map[y][x + 1]);
		}
		
		if(y - 1 >= 0) {
			count++;
			value += map[y - 1][x];
			min = Math.min(min, map[y - 1][x]);
		}
		
		if(x - 1 >= 0) {
			count++;
			value += map[y][x - 1];
			min = Math.min(min, map[y][x - 1]);
		}
		
		 if(count == 3) {
			result = Math.max(value, result);
			return;
		}else if(count == 4) {
			value -= min;
			result = Math.max(result, value);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				dfs(i, j, 0, 0);
				cross(i, j);
			}
		}
		
		System.out.println(result);
	}
}
