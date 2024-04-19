import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        br.close();
        
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    
    private static void dfs(int num) {
        visited[num] = true;
        dp[num][0] = 0;
        dp[num][1] = 1;
        
        for (int child : graph[num]) {
            if (!visited[child]) {
                dfs(child);
                dp[num][0] += dp[child][1];
                dp[num][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}