import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
        
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int res = 0;
        
            map = new int[N][M];
            visited = new boolean[N][M];
        
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
        
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        ++res;
                    }
                }
            }
            
            System.out.println(res);
        }
    }
    
    public static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{y, x});
        visited[y][x] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (map[ny][nx] == 1 && !visited[ny][nx]) {
                        q.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}