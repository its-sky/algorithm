import java.io.*;
import java.util.*;

public class Main {
    static int V, E, res = 0;
    static List<List<Node>> graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visited = new boolean[V + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, w));
            graph.get(e).add(new Node(s, w));
        }
        
        prim(1);
        System.out.println(res);
    }
    
    private static void prim(int start) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int node = curr.to;
            int weight = curr.value;
            
            if (visited[node]) continue;
            
            visited[node] = true;
            res += weight;
            
            for (Node next : graph.get(node)) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }
    }
    
    static class Node implements Comparable<Node> {
        int to, value;
        
        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }
        
        @Override
        public int compareTo(Node n) {
            return this.value - n.value;
        }
    }
}