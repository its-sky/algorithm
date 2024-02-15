import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] list;
    static boolean[] visited;
    static int res = 0;
    static int node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                list[start].add(new Node(end, cost));
            }
        }
        
        visited = new boolean[N + 1];
        dfs(1, 0);
        
        visited = new boolean[N + 1];
        dfs(node, 0);
        
        System.out.println(res);
    }

    private static void dfs(int x, int len) {
        if (len > res) {
            res = len;
            node = x;
        }
        visited[x] = true;
        
        for (int i = 0; i < list[x].size(); i++) {
            Node adj = list[x].get(i);
            if (!visited[adj.e]) {
                dfs(adj.e, adj.cost + len);
                visited[adj.e] = true;
            }
        }
    }
    
    static class Node {
        int e, cost;
        
        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
}