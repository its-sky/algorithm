import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, trgtLen;
    static int[][][] dp;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        char[][] map = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        char[] target = br.readLine().toCharArray();
        trgtLen = target.length;
        dp = new int[N][M][trgtLen];
        br.close();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        int cnt = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == target[0]) {
                    cnt += dfs(map, target, i, j, 0);
                }
            }
        }
        
        System.out.println(cnt);
    }
    
    private static int dfs(char[][] map, char[] target, int x, int y, int depth) {
        if (dp[x][y][depth] != -1) {
            return dp[x][y][depth];
        }
        
        if (depth == trgtLen - 1) {
            return 1;
        }
        
        int cnt = 0;
        
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j]*i;
                int ny = y + dy[j]*i;
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                
                if (map[nx][ny] == target[depth + 1]) {
                    cnt += dfs(map, target, nx, ny, depth + 1);
                }
            }
        }
        
        return dp[x][y][depth] = cnt;
    }
}