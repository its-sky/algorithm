import java.util.*;

class Solution {
    private static List<List<Integer>> graph;
    private static int[] dis;
    private static final int MAX = 1_000_000_000;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList<>();
        for (int i = 0; i < n+1; ++i) graph.add(new ArrayList<>());
        
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        dis = new int[n+1];
        Arrays.fill(dis, MAX);
        dijkstra(destination);
        
        int[] ans = new int[sources.length];
        for (int i = 0; i < sources.length; ++i) {
            ans[i] = (dis[sources[i]] < MAX) ? dis[sources[i]] : -1;
        }
        return ans;
    }
    
    private static void dijkstra(int destination) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);
        dis[destination] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int i = 0; i < graph.get(now).size(); ++i) {
                int nn = graph.get(now).get(i);
                if (dis[nn] > dis[now] + 1) {
                    dis[nn] = dis[now] + 1;
                    q.offer(nn);
                }
            }
        }
    }
}