import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_2583 {
	static int[][] map;
	static int[] di = {1, 0, -1, 0};
	static int[] dj = {0, 1, 0, -1};
	static int M, N;
	
	public static void draw(int x1, int y1, int x2, int y2) {
		for(int i = x1; i < x2; i++) {
			for(int j = y1; j < y2; j++) {
				map[i][j] = 1;
			}
		}
	}
	
	public static int dfs(int i, int j) {
		int ret = 1;
		
		for(int a = 0; a < 4; a++) {
			int ni = i + di[a];
			int nj = j + dj[a];
			
			if(ni >= M || ni < 0 || nj >= N || nj < 0 || map[ni][nj] != -1)
				continue;
			
			map[ni][nj] = 1;
			ret += dfs(ni, nj);
		}
		
		return ret;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		M = Integer.parseInt(strs[0]);
		N = Integer.parseInt(strs[1]);
		int K = Integer.parseInt(strs[2]);
		map = new int[M][N];
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < M; i++)
			Arrays.fill(map[i], -1);
		
		for(int i = 0; i < K; i++) {
			strs =br.readLine().split(" ");
			draw(Integer.parseInt(strs[1]), Integer.parseInt(strs[0]), Integer.parseInt(strs[3]), Integer.parseInt(strs[2]));
		}
		
		br.close();
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == -1) {
					map[i][j] = 1;
					result.add(dfs(i, j));
				}
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(int x : result)
			System.out.print(x + " ");
		
	}
}
