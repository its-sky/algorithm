import java.util.*;
import java.io.*;

public class Main {
    static int N, M, ans = 0, minHeight = Integer.MAX_VALUE;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                bfs(i, j, map[i][j]);
            }
        }
        
        System.out.println(ans);
    }
    
    public static void bfs(int y, int x, int height) {
        Queue<Loc> q = new LinkedList<>();
        boolean topFlag = true;
        q.offer(new Loc(y, x));
        visited[y][x] = true;
        
        while (!q.isEmpty()) {
            Loc loc = q.poll();
            for (int i = 0; i < 8; i++) {
                int ny = loc.y + dy[i];
                int nx = loc.x + dx[i];
                
                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (map[ny][nx] > height) topFlag = false;
                    else if (!visited[ny][nx] && map[ny][nx] == height) {
                        visited[ny][nx] = true;
                        q.offer(new Loc(ny, nx));
                    }
                }
            }
        }
        
        if (topFlag && height > minHeight) ++ans;
    }
    
    public static class Loc {
        int x, y;
        
        public Loc(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}