import java.io.*;
import java.util.*;

public class Main {
    static int N, M, start, end;
    static int[] parent;
    static List<Node> nodes;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }
    
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodes = new ArrayList<>();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes.add(new Node(a, b, w));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        br.close();
    }
    
    private static void process() {
        Collections.sort(nodes, (o1, o2) ->{
            return o2.w - o1.w;
        });
        
        for (Node node : nodes) {
            union(node.from, node.to);
            if (find(start) == find(end)) {
                System.out.println(node.w);
                return;
            }
        }
    }
    
    static void union(int u, int v) {
        u = find(u);
        v = find(v);
        
        if (u == v) return;
        
        if (u < v) {
            parent[v] = u;
        } else {
            parent[u] = v;
        }
    }
    
    static int find(int v) {
        if (v == parent[v]) return v;
        
        parent[v] = find(parent[v]);
        return parent[v];
    }
    
    static class Node {
        public int from, to, w;
        
        public Node(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
}