import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
 
class Edge implements Comparable<Edge>{
    int b, w;
     
    Edge(int b, int w){
        this.b = b;
        this.w = w;
    }
    @Override
    public int compareTo(Edge o) {
        return w <= o.w ? -1 : 1;
    }
}
 
public class BOJ_1753 {
    public static void main(String[] args) throws IOException {
         
        int INF = Integer.MAX_VALUE;
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] sc = s.split(" ");
         
        int point = Integer.parseInt(br.readLine());
        int vertex = Integer.parseInt(sc[0]);
        int edge = Integer.parseInt(sc[1]);
         
        List<Edge>[] list = new ArrayList[vertex + 1];
        for(int i = 1; i <= vertex; i++){
            list[i] = new ArrayList<>();
        }
         
        for(int i = 0; i < edge; i++){
            s = br.readLine();
            sc = s.split(" ");
            list[Integer.parseInt(sc[0])].add(new Edge(Integer.parseInt(sc[1]), Integer.parseInt(sc[2])));
        }
         
        br.close();
        int[] dij = new int[vertex + 1];
        boolean[] visited = new boolean[vertex + 1];
        for(int i = 1; i <= vertex; i++){
            dij[i] = INF;
        }
         
        dij[point] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(point, dij[point]));
         
        while(!pq.isEmpty()){
            int current;
            do{
                current = pq.peek().b;
                pq.poll();
                 
            }while(!pq.isEmpty() && visited[current]);
             
            if(visited[current]) break;
            visited[current] = true;
             
            for(Edge e : list[current]){
                int next = e.b;
                int dist = Math.min(dij[next], dij[current] + e.w);
                if(dist == dij[current] + e.w){
                    dij[next] = dist;
                    pq.add(new Edge(next, dij[next]));
                     
                }
            }
             
                 
        }
         
        for(int i = 1; i <= vertex; i++){
            if(dij[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dij[i]);
        }
         
    }
 
 
}
