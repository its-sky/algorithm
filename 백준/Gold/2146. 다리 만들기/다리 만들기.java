import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        br.close();
        visited = new boolean[N][N];
        int landNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    changeLandNumber(i, j, landNum++);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) continue;
                int lNum = hasLandNearBy(i, j);
                if (lNum > 0) {
                    int tmp = bfs(i, j, lNum);
                    if (tmp == -1) continue;
                    res = Math.min(res, bfs(i, j, lNum));
                }
            }
        }
        
        System.out.println(res);
    }
    
    private static int bfs(int x, int y, int landNum) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 1));
        visited = new boolean[N][N];
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            Point curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                
                if (map[nx][ny] > 0 && map[nx][ny] != landNum) {
                    return curr.step;
                }
                
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    q.offer(new Point(nx, ny, curr.step+1));
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
    
    private static void changeLandNumber(int x, int y, int num) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 0));
        map[x][y] = num;
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            Point curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                
                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    q.offer(new Point(nx, ny, 0));
                    map[nx][ny] = num;
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    private static int hasLandNearBy(int x, int y) {
        int cnt = 0;
        int landNum = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            
            if (map[nx][ny] != 0) {
                ++cnt;
                landNum = map[nx][ny];
            }
        }
        
        if (cnt > 0 && cnt < 4) return landNum;
        if (cnt == 4) return -1;
        return 0;
    }
    
    static class Point {
        int x, y, step;
        
        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}