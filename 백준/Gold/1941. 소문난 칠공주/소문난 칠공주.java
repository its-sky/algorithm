import java.io.*;
import java.util.*;

public class Main {
    static final char[][] map = new char[5][5];
    static final boolean[][] visited = new boolean[5][5];
    static final int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int cs = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        dfs(0, 0);
        System.out.println(cs);
    }
    
    private static void dfs(int nowDepth, int start) {
        if (nowDepth == 7) {
            if (checkLinked()) ++cs;
        } else {
            for (int i = start; i < 25; i++) {
                visited[i / 5][i % 5] = true;
                dfs(nowDepth + 1, i + 1);
                visited[i / 5][i % 5] = false;
            }
        }
    }
    
    private static boolean checkLinked() {
        boolean[][] copyVisited = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            copyVisited[i] = visited[i].clone();
        }
        
        int x = 0, y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (copyVisited[i][j]) {
                    x = i;
                    y = j;
                }
            }
        }
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        
        int cnt = 0;
        int s = 0;
        while (!q.isEmpty()) {
            Point curr = q.poll();
            
            for (int[] dir : dirs) {
                int nx = curr.x + dir[0];
                int ny = curr.y + dir[1];
                
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                
                if (copyVisited[nx][ny]) {
                    if (map[nx][ny] == 'S') ++s;
                    ++cnt;
                    q.offer(new Point(nx, ny));
                    copyVisited[nx][ny] = false;
                }
            }
        }
        if (cnt == 7 && s >= 4) return true;
        return false;
    }
    
    static class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}