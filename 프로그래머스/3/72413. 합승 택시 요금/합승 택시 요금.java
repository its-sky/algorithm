import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], 200000001);
            dp[i][i] = 0;
        }
        
        for (int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int w = fare[2];
            
            dp[start][end] = w;
            dp[end][start] = w;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        
        int res = dp[s][a] + dp[s][b];
        
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, dp[s][i] + dp[i][a] + dp[i][b]);
        }
        
        return res;
    }
}