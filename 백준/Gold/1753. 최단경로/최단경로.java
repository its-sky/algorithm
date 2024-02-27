import java.io.*;
import java.util.*;

public class Main {
    static int V, E, S;
    static int INF = 100_000_000;
    static int[] dist;
    static List<List<Edge>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        
        int s, e, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Edge(e, w));
        }
        
        StringBuilder sb = new StringBuilder();
        dijkstra(S);
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        
        System.out.println(sb);
        br.close();
    }
    
    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Edge currEdge = pq.poll();
            int cur = currEdge.e;
            
            if (visited[cur]) continue;
            visited[cur] = true;
            
            for (Edge edge : graph.get(cur)) {
                if (dist[edge.e] > dist[cur] + edge.w) {
                    dist[edge.e] = dist[cur] + edge.w;
                    pq.offer(new Edge(edge.e, dist[edge.e]));
                }
            }
        }
    }
    
    static class Edge implements Comparable<Edge> {
        int e, w;
        
        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}