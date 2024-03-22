import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        dp = new boolean[N + 1][N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        solve(arr, N);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            if (dp[start][end]) sb.append("1\n");
            else sb.append("0\n");
        }
        
        System.out.println(sb);
    }
    
    private static void solve(int[] arr, int N) {
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }
        
        for (int i = 1; i <= N - 1; i++) {
            if (arr[i] == arr[i + 1]) dp[i][i + 1] = true;
        }
        
        for (int i = 2; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }
    }
}