import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int x, y, d;
    static int[][] map;
    static boolean[][] clean;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        clean = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(move());
    }
    
    private static int move() {
        int countClean = 0;
        while (true) {
            if (!clean[x][y]) {
                ++countClean;
                clean[x][y] = true;
            }
            int countDirties = countDirty();
            if (countDirties == 0) {
                int code = moveOpposite();
                if (code == -1) {
                    break;
                }
            } else {
                d = (d + 3) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (map[nx][ny] == 0 && !clean[nx][ny]) {
                    x = nx;
                    y = ny;
                }
            }
        }
        return countClean;
    }
    
    private static int countDirty() {
        int result = 0;
        
        for (int i = 0; i < 4; i++) {
            int currD = (d + i) % 4;
            
            int nx = x + dx[currD];
            int ny = y + dy[currD];
            
            if (map[nx][ny] == 1) continue;
            
            if (!clean[nx][ny]) ++result;
        }
        return result;
    }
    
    private static int moveOpposite() {
        int currD = (d + 2) % 4;
        
        int nx = x + dx[currD];
        int ny = y + dy[currD];
        
        if (map[nx][ny] == 1) return -1;
        
        x = nx;
        y = ny;
        return 0;
    }
}