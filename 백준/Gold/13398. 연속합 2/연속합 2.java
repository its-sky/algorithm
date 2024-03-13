import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[N][2];
        dp[0][0] = arr[0];
        dp[0][0] = arr[0];
        
        int max = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+arr[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        
        System.out.println(max);
    }
}