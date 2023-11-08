import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Node>> map;
    static int[] dist;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        map = new ArrayList<>();
        dist = new int[N + 1];
        check = new boolean[N + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map.get(s).add(new Node(e, w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        System.out.println(dijkstra(start, end));
        
        br.close();
    }
    
    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;
            
            if (!check[cur]) {
                check[cur] = true;
                
                for (Node node : map.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.offer(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }
        
    static class Node implements Comparable<Node> {
        public int end, weight;
        
        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}