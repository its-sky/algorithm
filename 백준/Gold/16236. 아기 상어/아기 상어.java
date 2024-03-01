import java.io.*;
import java.util.*;

public class Main {
    static int N, x, y, res, size;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        Point curr = new Point(0, 0, 0);
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 9) {
                    curr.x = i;
                    curr.y = j;
                    map[i][j] = 0;
                }
            }
        }
        br.close();
        
        size = 2;
        res = 0;
        int eat = 0;
        
        while (true) {
             PriorityQueue<Point> q = new PriorityQueue<>((o1, o2) ->
                o1.val != o2.val ? Integer.compare(o1.val, o2.val) : (o1.x != o2.x ? Integer.compare(o1.x, o2.x) : Integer.compare(o1.y, o2.y))
            );
            boolean[][] visited = new boolean[N][N];
            boolean ate = false;
        
            q.offer(new Point(curr.x, curr.y, 0));
            visited[curr.x][curr.y] = true;
        
            while (!q.isEmpty()) {
                curr = q.poll();
                
                if (map[curr.x][curr.y] != 0 && map[curr.x][curr.y] < size) {
                    map[curr.x][curr.y] = 0;
                    ++eat;
                    res += curr.val;
                    ate = true;
                    break;
                }
            
                for (int i = 0; i < 4; i++) {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];
                
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] > size) continue;
                
                    q.offer(new Point(nx, ny, curr.val + 1));
                    visited[nx][ny] = true;
                }
            }
            
            if (!ate) break;
            
            if (size == eat) {
                ++size;
                eat = 0;
            }
        }
        
        System.out.println(res);
        
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