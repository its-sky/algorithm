import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[T + 1];
        
        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int[][][] dp = new int[T + 1][3][W + 1];
        
        if (arr[1] == 1) {
            dp[1][1][0] = 1;
            dp[1][1][1] = 1;
        } else if (arr[1] == 2) {
            dp[1][2][1] = 1;
        }
        
        for (int i = 2; i <= T; i++) {
            for (int j = 0; j <= i && j <= W; j++) {
                dp[i][arr[i]][j] = Math.max(dp[i][arr[i]][j], dp[i-1][arr[i]][j] + 1);
                if (j >= 1) {
                    if (arr[i] == 1) {
                        dp[i][1][j] = Math.max(dp[i][1][j], Math.max(dp[i-1][2][j-1], dp[i-1][1][j])+1);
                        dp[i][2][j] = dp[i-1][2][j];
                    } else {
                        dp[i][1][j] = dp[i-1][1][j];
                        dp[i][2][j] = Math.max(dp[i][2][j], Math.max(dp[i-1][1][j-1], dp[i-1][2][j])+1);
                    }
                }
            }
        }
        
        int max = 0;
        
        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j <= W; j++) {
                max = Math.max(max, dp[T][i][j]);
            }
        }
        
        System.out.println(max);
    }
}