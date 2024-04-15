import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int r, c, res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = null;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        res = -1;
        
        br.close();
        
        bfs(r, c);
        
        System.out.println(res);
    }
    
    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c, 0));
        visited[r][c] = true;
        
        while (!q.isEmpty()) {
            Point curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                
                if (!visited[nx][ny]) {
                    if (map[nx][ny] == 1) {
                        res = curr.val + 1;
                        break;
                    }
                    if (map[nx][ny] == 0) {
                        q.offer(new Point(nx, ny, curr.val + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
            if (res != -1) break;
        }
    }
    
    static class Point {
        int x, y, val;
        
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}