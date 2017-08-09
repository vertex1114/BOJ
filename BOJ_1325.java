import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1325 {
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	
	public static int dfs(int start) {
		visited[start] = true;
		int ret = 1;
		
		for(int i : list[start]) {
			if(!visited[i])
				ret += dfs(i);
		}
		
		return ret;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		int max = 0;
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			list[Integer.parseInt(strs[1])].add(Integer.parseInt(strs[0]));
		}
		
		for(int i = 1; i <= N; i++) {
			Arrays.fill(visited, false);
			int count = dfs(i);
			
			if(max < count) {
				max = count;
				q.clear();
				q.add(i);
			}else if(max == count)
				q.add(i);
		}
		
		for(int x : q)
			System.out.print(x + " ");
	}
}
