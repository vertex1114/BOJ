import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1697 {
	static int N, K;
	static int result = Integer.MAX_VALUE;
	static int[] cache = new int[100001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> qc = new LinkedList<>();
		q.add(N);
		qc.add(0);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			int count = qc.poll();
			
			if(now == K) {
				result = count;
				break;
			}
			
			for(int i = 0; i < 3; i++) {
				int next;
				
				if(i == 0)
					next= now + 1;
				else if(i ==1)
					next = now - 1;
				else
					next = now * 2;
				
				if(next > 100000 || next < 0 || cache[next] != 0)
					continue;
				
				cache[next] = cache[now] + 1;
				q.add(next);
				qc.add(count + 1);
			}
		}
		
		System.out.println(cache[K]);
	}
}
