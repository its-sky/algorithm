import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        int[] dp = new int[N];
        String[] str = new String[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            str[i] = String.valueOf(arr[i]);
            
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    str[i] = str[j] + " " + arr[i];
                }
            }
        }
        
        int max = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (max < dp[i]) {
                max = dp[i];
                idx = i;
            }
        }
        
        System.out.println(max);
        System.out.println(str[idx]);
    }
}