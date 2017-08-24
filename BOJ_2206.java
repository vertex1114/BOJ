import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point{
	int x, y, destory;
	
	Point(int x, int y, int destory){
		this.x = x;
		this.y = y;
		this.destory = destory;
	}
}

public class BOJ_2206 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		int result = Integer.MAX_VALUE;
		int[][] map = new int[N +1][M + 1];
		int[][][] cache = new int[N + 1][M + 1][2];
		cache[1][1][0] = 1;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(1, 1, 0));
	
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			
			for(int j = 1; j <= M; j++) 
				map[i][j] = str.charAt(j - 1) - '0';
		}
	
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(now.y == N && now.x == M) {
				result = Math.min(result, cache[now.y][now.x][now.destory]);
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int destory = now.destory;
				
				if(nx > M || ny > N || nx < 1 || ny < 1 || cache[ny][nx][destory] != 0)
					continue;
				
				if(destory == 1 && (map[ny][nx] == 1 || cache[ny][nx][0] != 0))
					continue;
				
				if(destory == 0 && map[ny][nx] ==  1)
					destory = 1;
				
				cache[ny][nx][destory] = cache[now.y][now.x][now.destory] + 1;
				q.add(new Point(nx, ny, destory));
			}
		}
		
		if(result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}
}
