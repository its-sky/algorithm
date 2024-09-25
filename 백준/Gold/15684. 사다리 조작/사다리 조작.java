import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H, answer;
    static int[][] map;
    static boolean hasFinished = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        map = new int[H + 1][N + 1];
        
        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[x][y + 1] = 2;
        }
        
        for (int i = 0; i <= 3; i++) {
            answer = i;
            dfs(1, 0);
            if (hasFinished) break;
        }
        
        System.out.println((hasFinished) ? answer : -1);
    }
    
    private static void dfs(int x, int count) {
        if (hasFinished) return;
        
        if (answer == count) {
            if (check()) hasFinished = true;
            return;
        }
        
        for (int i = x; i < H + 1; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(i, count + 1);
                    map[i][j] = map[i][j + 1] = 0;
                }
            }
        }
    }
    
    private static boolean check() {
        for (int i = 1; i <= N; i++) {
            int x = 1, y = i;
            for (int j = 0; j < H; j++) {
                if (map[x][y] == 1) ++y;
                else if (map[x][y] == 2) --y;
                ++x;
            }
            if (y != i) return false;
        }
        return true;
    }
}