import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] indegree = new int[N + 1];
        int[] time = new int[N + 1];
        int[] dp = new int[N + 1];
        List<Integer>[] adj = new ArrayList[N + 1];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1) break;
                adj[tmp].add(i);
                indegree[i] += 1;
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                dp[i] = time[i];
            }
        }
            
        while (!q.isEmpty()) {
            Integer curr = q.poll();
                
            for (Integer tmp : adj[curr]) {
                indegree[tmp] -= 1;
                dp[tmp] = Math.max(dp[tmp], dp[curr] + time[tmp]);
                if (indegree[tmp] == 0) {
                    q.offer(tmp);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dp[i] + "\n");
        }
        System.out.println(sb);
    }
}