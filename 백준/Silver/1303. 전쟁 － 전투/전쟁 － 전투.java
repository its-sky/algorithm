import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }
        br.close();
        int[] res = new int[2];
        int tmp = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    tmp = bfs(i, j);
                    if (map[i][j] == 'W') {
                        res[0] += tmp * tmp;
                    } else {
                        res[1] += tmp * tmp;
                    }
                }
            }
        }
        
        System.out.println(res[0] + " " + res[1]);
    }
    
    private static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        int count = 1;
        
        while (!q.isEmpty()) {
            Point curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                
                if (!visited[nx][ny] && map[nx][ny] == map[x][y]) {
                    ++count;
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        
        return count;
    }
    
    static class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}