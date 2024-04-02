import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, dp;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = -1;
            }
        }
        
        System.out.println(dfs(1, 1));
    }
    
    private static int dfs(int x, int y) {
        if (x == N && y == M) {
            return 1;
        }
        
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        
        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 1 || nx > N || ny < 1 || ny > M) continue;
            
            if (map[x][y] > map[nx][ny]) {
                dp[x][y] += dfs(nx, ny);
            }
        }
        
        return dp[x][y];
    }
}