import java.io.*;
import java.util.*;

public class Main {
    static int N, INF = Integer.MAX_VALUE;
    static int[] data;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        data = new int[N + 1];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            data[i] = a;
            data[i + 1] = b;
        }
        br.close();
        dp = new int[N][N];
        
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                dp[j][j+i-1] = INF;
                for (int k = j; k < j + i - 1; k++) {
                    int value = dp[j][k] + dp[k+1][j+i-1] + (data[j]*data[k+1]*data[j+i]);
                    dp[j][j+i-1] = Math.min(dp[j][j+i-1], value);
                }
            }
        }
        
        System.out.println(dp[0][N-1]);
    }
}