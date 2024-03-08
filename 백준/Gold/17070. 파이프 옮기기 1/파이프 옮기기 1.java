import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dr = {0, 1, 2}; // 가로, 대각선, 세로
    static int[][] map;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N+1][N+1][3];
        
        dp[0][1][0] = 1;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j+1] == 0) {
                    dp[i][j+1][0] += dp[i][j][0] + dp[i][j][1];
                }
                if (map[i+1][j] == 0) {
                    dp[i+1][j][2] += dp[i][j][1] + dp[i][j][2];
                }
                if (map[i+1][j] == 0 && map[i][j+1] == 0 && map[i+1][j+1] == 0) {
                    dp[i+1][j+1][1] = dp[i][j][0] + dp[i][j][1] + dp[i][j][2];
                }
            }
        }
        
        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
        
    }
}