import java.io.*;
import java.util.*;

public class Main {
    static int N, M, age;
    static int[][] map;
    static int[][] diff;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        br.close();
        
        boolean flag = process();
        
        if (!flag) {
            System.out.println(0);
        } else {
            System.out.println(age);
        }
    }
    
    private static boolean process() {
        int cntLand = 0;
        age = 0;
        while (true) {
            aging();
            visited = new boolean[N][M];
            cntLand = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        bfs(i, j);
                        if (++cntLand >= 2) {
                            return true;
                        }
                    }
                }
            }
            if (cntLand == 0) break;
        }
        
        return false;
    }
    
    private static void aging() {
        diff = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    diff[i][j] = countAdjSea(i, j);
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = Math.max(0, map[i][j] - diff[i][j]);
            }
        }
        ++age;
    }
    
    private static int countAdjSea(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
                
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            
            if (map[nx][ny] == 0) ++cnt;
        }
        
        return cnt;
    }
    
    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                
                if (!visited[nx][ny] && map[nx][ny] > 0) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}