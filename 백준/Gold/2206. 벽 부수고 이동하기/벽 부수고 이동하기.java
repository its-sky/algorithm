import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res;
    static boolean[][][] visited;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M][2];
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        br.close();
        res = -1;
        
        bfs();
    }
    
    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;
        
        while (!q.isEmpty()) {
            Point curr = q.poll();
            
            if (curr.x == N - 1 && curr.y == M - 1) {
                System.out.println(curr.count);
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                
                int next_count = curr.count + 1;
                
                if (map[nx][ny] == '1') {
                    if (curr.crash == 0) {
                        q.offer(new Point(nx, ny, next_count, 1));
                        visited[nx][ny][1] = true;
                    }
                } else if (map[nx][ny] == '0') {
                    if (!visited[nx][ny][0] && curr.crash == 0) {
                        q.offer(new Point(nx, ny, next_count, 0));
                        visited[nx][ny][0] = true;
                    } else if (!visited[nx][ny][1] && curr.crash == 1) {
                        q.offer(new Point(nx, ny, next_count, 1));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
    
    static class Point {
        int x, y, count, crash;
        
        public Point(int x, int y, int count, int crash) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.crash = crash;
        }
    }
}