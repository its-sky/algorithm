import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        long[][] dp = new long[N][21];
        
        int plus, minus;
        dp[0][arr[0]] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i-1][j] != 0) {
                    plus = j + arr[i];
                    minus = j - arr[i];
                    
                    if (plus >= 0 && plus <= 20) {
                        dp[i][plus] += dp[i-1][j];
                    }
                    if (minus >= 0 && minus <= 20) {
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }
        
        System.out.println(dp[N-2][arr[N-1]]);
    }
}