import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[2002][2002];
    static boolean[][] visited = new boolean[2002][2002];
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Point> points = new ArrayList<>();
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = 1000 + Integer.parseInt(st.nextToken()) * 2;
            int y1 = 1000 + Integer.parseInt(st.nextToken()) * 2;
            int x2 = 1000 + Integer.parseInt(st.nextToken()) * 2;
            int y2 = 1000 + Integer.parseInt(st.nextToken()) * 2;
            points.add(new Point(x1, y1));
            for (int j = x1; j <= x2; j++) {
                map[j][y1] = 1;
                map[j][y2] = 1;
            }
            for (int j = y1; j <= y2; j++) {
                map[x1][j] = 1;
                map[x2][j] = 1;
            }
        }
        
        int res = 0;
        
        if (map[1000][1000] == 1) --res;
        
        for (Point p : points) {
            if (!visited[p.x][p.y]) {
                ++res;
                bfs(p.x, p.y);
            }
        }
        
        System.out.println(res);
    }
    
    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            Point curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if (nx < 0 || nx >= 2002 || ny < 0 || ny >= 2002) continue;
                
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
    
    static class Point {
        int x, y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}