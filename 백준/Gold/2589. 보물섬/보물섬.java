import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    int moves = bfs(i, j, map);
                    if (moves > res) {
                        res = moves;
                    }
                }
            }
        }
        System.out.println(res);
        br.close();
    }
    
    private static int bfs(int x, int y, char[][] map) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 0));
        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;
        int moves = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Point curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == 'L') {
                    q.offer(new Point(nx, ny, curr.cnt + 1));
                    visited[nx][ny] = true;
                    if (curr.cnt + 1 > moves) {
                        moves = curr.cnt + 1;
                    }
                }
            }
        }
        return moves;
    }
    
    public static class Point {
        public int x, y, cnt;
        
        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}