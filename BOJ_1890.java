import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1890 {
	static int[][] map;
	static long[][] cache;
	static int size;
	static int[] dy = {0, 1};
	static int[] dx = {1, 0};
	
	public static long dfs(int x, int y) {
		if(cache[y][x] != -1) return cache[y][x];
		
		cache[y][x] = 0;
		
		for(int i = 0; i < 2; i++) {
			int nx = x + map[y][x]*dx[i];
			int ny = y + map[y][x]*dy[i];
			
			if(nx >= size || ny >= size)
				continue;
			
			cache[y][x] += dfs(nx, ny);
		}
		
		return cache[y][x];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		cache = new long[size][size];
		
		for(int i = 0; i < size; i++)
			Arrays.fill(cache[i], -1);
		
		cache[size - 1][size-1] = 1;
		
		for(int i = 0; i < size; i++) {
			String[] strs = br.readLine().split(" ");
			
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		System.out.println(dfs(0,0));
	}
}
