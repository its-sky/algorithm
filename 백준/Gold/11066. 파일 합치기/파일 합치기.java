import java.io.*;
import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int K = Integer.parseInt(br.readLine());
            int[] files = new int[K + 1];
            int[] sum = new int[K + 1];
            
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + files[i];
            }

            int[][] dp = new int[K+1][K+1];
            for (int n = 1; n <= K; n++) {
                for (int from = 1; from <= K - n; from++) {
                    int to = from + n;
                    dp[from][to] = INF;
                    for (int divide = from; divide < to; divide++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }
            
            System.out.println(dp[1][K]);
        }
        br.close();
    }
}