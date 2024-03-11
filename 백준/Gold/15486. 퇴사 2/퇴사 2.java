import java.io.*;
import java.util.*;

public class Main {
    static int[][] cost;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        cost = new int[N + 2][2];
        dp = new int[N + 51];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        for (int i = 1; i <= N + 1; i++) {
            if (max < dp[i]) max = dp[i];
            
            int next = i + cost[i][0];
            if (next < N + 2) {
                dp[next] = Math.max(dp[next], max + cost[i][1]);
            }
        }
        
        System.out.println(dp[N+1]);
    }
}