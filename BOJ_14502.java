import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14502 {
	static int N, M;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Integer> virus = new LinkedList<>();
	static int result = 0;
	
	public static void backtracking(int count) {
		if(count < 3) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 0) {
						map[i][j] = 1;
						backtracking(count + 1);
						map[i][j] = 0;
					}
				}
			}
		}else {
			int[][] temp = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++){
					temp[i][j] = map[i][j];
				}
			}
			infect();
			result = Math.max(result, count());
			map = temp;
		}
	}
	
	public static void infect() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) {
					virus.add(j);
					virus.add(i);
				}
			}
		}
		
		while(!virus.isEmpty()) {
			int cx = virus.poll();
			int cy = virus.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(ny >=N || nx >= M || nx < 0 || ny < 0 || map[ny][nx] != 0) 
					continue;
				
				map[ny][nx] = 2;
				virus.add(nx);
				virus.add(ny);
			}
		}
	}
	
	public static int count() {
		int ret = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++){
				if(map[i][j] == 0)
					ret++;
			}
		}
		
		return ret;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		map = new int[N][M];
		//0 빈칸 1 벽 2 바이러스
		
		for(int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		backtracking(0);
		System.out.println(result);
	}
}
