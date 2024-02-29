import java.io.*;
import java.util.*;

public class Main {
    static int N, statusFullBit, INF = 987654321;
    static int[][] w;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        statusFullBit = (1 << N) - 1;
        w = new int[N][N];
        dp = new int[N][statusFullBit];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(tsp(0, 1));
    }
    
    private static int tsp(int x, int check) {
        if (check == statusFullBit) {
            if (w[x][0] == 0) return INF;
            else return w[x][0];
        }
        
        if (dp[x][check] != -1) return dp[x][check];
        
        dp[x][check] = INF;
        
        for (int i = 0; i < N; i++) {
            int next = check | (1 << i);
            
            if (w[x][i] == 0 || (check & (1 << i)) != 0) continue;
            
            dp[x][check] = Math.min(dp[x][check], tsp(i, next) + w[x][i]);
        }
        
        return dp[x][check];
    }
}