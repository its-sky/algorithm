import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] arr = new int[N + 1];
        int[] dp = new int[K + 1];
        Arrays.fill(dp, 987654321);
        
        for (int j = 1; j <= N; j++) {
            arr[j] = Integer.parseInt(br.readLine());
        }
        
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = arr[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
        
        if (dp[K] == 987654321) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[K]);
    }
}