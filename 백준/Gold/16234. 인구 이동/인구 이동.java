import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R, day;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        day = -1;
        
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        
        boolean moved = true;
        while (moved) {
            day += 1;
            moved = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) moved = true;
                    }
                }
            }
        }
        
        System.out.println(day);
    }
    
    private static boolean bfs(int x, int y) {
        List<int[]> record = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        int total = map[x][y];
        record.add(new int[]{x, y});
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                
                int diff = Math.abs(map[curr[0]][curr[1]] - map[nx][ny]);
                if (diff >= L && diff <= R) {
                    record.add(new int[]{nx, ny});
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    total += map[nx][ny];
                }
            }
        }
        
        if (record.size() == 1) {
            return false;
        }
        
        int division = total / record.size();
        for (int[] point : record) {
            map[point[0]][point[1]] = division;
        }
        return true;
    }
}