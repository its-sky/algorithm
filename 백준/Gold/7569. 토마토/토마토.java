import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H, res;
    static int[][][] box;
    static boolean[][][] visited;
    static int[] dx={-1, 1, 0, 0, 0, 0}, dy={0, 0, -1, 1, 0, 0}, dz={0, 0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        res = 0;
        box = new int[H][N][M];
        visited = new boolean[H][N][M];
        
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        q.offer(new Point(i, j, k, -1));
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        br.close();
                
        bfs(q);
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!visited[i][j][k]) {
                        if (box[i][j][k] == 0) {
                            System.out.println(-1);
                            return;   
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
    
    private static void bfs(Queue<Point> q) {
        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (res < curr.time) res = curr.time;
            for (int i = 0; i < 6; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                int nz = curr.z + dz[i];
                if (!isInBox(nx, ny, nz)) continue;
                
                if (box[nx][ny][nz] == 0 && !visited[nx][ny][nz]) {
                    q.offer(new Point(nx, ny, nz, curr.time));
                    visited[nx][ny][nz] = true;
                }
            }
        }
    }
    
    private static boolean isInBox(int x, int y, int z) {
        if (x < 0 || x >= H || y < 0 || y >= N || z < 0 || z >= M) return false;
        return true;
    }
    
    static class Point {
        public int x, y, z, time;
        
        public Point(int x, int y, int z, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time + 1;
        }
    }
}