import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer[]>[] graph;
    static boolean[] visited;
    static int max = 0, findNode = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Integer[]{b, cost});
            graph[b].add(new Integer[]{a, cost});
        }
        dfs(1, 0);
        max = 0;
        Arrays.fill(visited, false);
        dfs(findNode, 0);
        
        System.out.println(max);
        br.close();
    }
    
    private static void dfs(int node, int sum) {
        visited[node] = true;
        if (sum > max) {
            max = sum;
            findNode = node;
        }
        
        for (Integer[] tmp : graph[node]) {
            int next = tmp[0];
            int cost = tmp[1];
            if (!visited[next]) {
                dfs(next, sum + cost);
            }
        }
    }
}