import java.util.*;

class Solution {
    
    static int[] dist;
    static ArrayList<ArrayList<Edge>> adj;
    static PriorityQueue<Edge> pq;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        dist = new int[N + 1];
        adj = new ArrayList<>();
        pq = new PriorityQueue<>();
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= N; ++i) adj.add(new ArrayList<>());
        
        for (int i = 0; i < road.length; ++i) {
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];
            
            adj.get(from).add(new Edge(to, weight));
            adj.get(to).add(new Edge(from, weight));
        }
        
        dist[1] = 0;
        pq.offer(new Edge(1, 0));
        
        dijkstra();
        
        for (int distance : dist) {
            if (distance <= K) ++answer;
        }

        return answer;
    }
    
    private void dijkstra() {
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            
            for (Edge ne : adj.get(e.to)) {
                if (dist[ne.to] > dist[e.to] + ne.weight) {
                    dist[ne.to] = dist[e.to] + ne.weight;
                    pq.offer(ne);
                }
            }
        }
    }
    
    static class Edge implements Comparable<Edge> {
        int to, weight;
        
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
}