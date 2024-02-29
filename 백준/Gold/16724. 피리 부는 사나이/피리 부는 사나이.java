import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int res = 0;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited, finished;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        finished = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            char[] inputs = br.readLine().toCharArray();
            for (int j = 0; j < inputs.length; j++) {
                char c = inputs[j];
                if (c == 'U') map[i][j] = 0;
                else if (c == 'D') map[i][j] = 1;
                else if (c == 'L') map[i][j] = 2;
                else if (c == 'R') map[i][j] = 3;
            }
        }
        br.close();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }
        
        System.out.println(res);
    }
    
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        
        int nx = x + dx[map[x][y]];
        int ny = y + dy[map[x][y]];
        
        if (!visited[nx][ny]) {
            dfs(nx, ny);
        } else {
            if (!finished[nx][ny]) ++res;
        }
        
        finished[x][y] = true;
    }
    
}