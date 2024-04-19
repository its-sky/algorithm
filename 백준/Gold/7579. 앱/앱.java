import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int res = Integer.MAX_VALUE;
        
        int[] memory = new int[N];
        int[] cost = new int[N];
        int[] dp = new int[10001];
        
        st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
        }
        br.close();
        
        for (int i = 0; i <= 10000; i++) {
            dp[i] = -1;
        }
        
        for (int i = 0; i < N; i++) {
            int cur = cost[i];
            
            for (int j = 10000; j >= cur; j--) {
                if (dp[j - cur] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - cur] + memory[i]);
                }
            }
            dp[cur] = Math.max(dp[cur], memory[i]);
        }
        
        for (int i = 0; i <= 10000; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}