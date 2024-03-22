import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        int resRG = 0;
        // RG
        Map<Character, Boolean> check = new HashMap<>();
        check.put('R', true);
        check.put('G', true);
        check.put('B', false);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && (map[i][j] == 'R' || map[i][j] == 'G')) {
                    bfs(i, j, check);
                    ++resRG;
                }
            }
        }
        
        // B
        int resB = 0;
        check = new HashMap<>();
        check.put('R', false);
        check.put('G', false);
        check.put('B', true);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 'B') {
                    bfs(i, j, check);
                    ++resB;
                }
            }
        }
        
        visited = new boolean[N][N];
        // G
        int resG = 0;
        check = new HashMap<>();
        check.put('R', false);
        check.put('G', true);
        check.put('B', false);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 'G') {
                    bfs(i, j, check);
                    ++resG;
                }
            }
        }
        
        // R
        int resR = 0;
        check = new HashMap<>();
        check.put('R', true);
        check.put('G', false);
        check.put('B', false);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 'R') {
                    bfs(i, j, check);
                    ++resR;
                }
            }
        }
        
        System.out.println((resR + resG + resB) + " " + (resRG + resB));
    }
    
    private static void bfs(int x, int y, Map<Character, Boolean> check) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                
                if (!visited[nx][ny] && check.get(map[nx][ny])) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}