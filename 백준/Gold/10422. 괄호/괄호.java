import java.io.*;
import java.util.*;

public class Main {
    static int L;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp = new long[5001];
            
        dp[0] = 1;
        dp[2] = 1;

        for (int i = 2; i < 2501; i++) {
            for (int j = 0; j < i; j++) {
                dp[i*2] += dp[j*2]*dp[(i-1-j)*2];
                dp[i*2] %= 1000000007L;
            }
        }
        
        for (int tc = 0; tc < T; tc++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(dp[a]);
        }
        br.close();
    }
}