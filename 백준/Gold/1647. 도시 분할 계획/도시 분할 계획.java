import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static List<Edge> edgeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        edgeList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            edgeList.add(new Edge(s, e, w));
        }
        
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) parent[i] = i;
        
        Collections.sort(edgeList);
        
        int ans = 0;
        int bigCost = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            
            if (find(edge.s) != find(edge.e)) {
                ans += edge.w;
                union(edge.s, edge.e);
                
                bigCost = edge.w;
            }
        }
        
        System.out.println(ans - bigCost);
        br.close();
    }
    
    private static int find(int n) {
        if (n == parent[n]) return n;
        return parent[n] = find(parent[n]);
    }
    
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) {
            parent[y] = x;
        }
    }
    
    static class Edge implements Comparable<Edge> {
        int s, e, w;
        
        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}