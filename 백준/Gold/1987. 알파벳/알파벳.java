import java.io.*;
import java.util.*;

public class Main {
    static int R, C, res;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] used;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        res = Integer.MIN_VALUE;
        map = new char[R][C];
        visited = new boolean[R][C];
        used = new boolean[26];
        
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        visited[0][0] = true;
        used[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        
        System.out.println(res);
        br.close();
    }
    
    private static void dfs(int x, int y, int depth) {
        res = Math.max(res, depth);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            
            if (!visited[nx][ny] && !used[(int)(map[nx][ny] - 'A')]) {
                visited[nx][ny] = true;
                used[(int)(map[nx][ny] - 'A')] = true;
                dfs(nx, ny, depth + 1);
                visited[nx][ny] = false;
                used[(int)(map[nx][ny] - 'A')] = false;
            }
        }
    }
}