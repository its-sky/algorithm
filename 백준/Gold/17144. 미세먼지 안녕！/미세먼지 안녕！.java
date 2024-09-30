import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int upAirRow = 0, downAirRow = 0;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int firstVal = Integer.parseInt(st.nextToken());
            if (upAirRow == 0 && firstVal == -1) {
                upAirRow = i;
                downAirRow = i + 1;
            }
            map[i][0] = firstVal;
            for (int j = 1; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        
        for (int time = 0; time < T; time++) {
            spreadDust();
            moveDust();
        }
        
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    result += map[i][j];
                }
            }
        }
        System.out.println(result);
    }
    
    private static void moveDust() {
        // upper
        int x = upAirRow;
        int y = 0;
        while (x > 0) {
            map[x][y] = map[x-- - 1][y];
        }
        while (y < C - 1) {
            map[x][y] = map[x][y++ + 1];
        }
        while (x < upAirRow) {
            map[x][y] = map[x++ + 1][y];
        }
        while (y > 1) {
            map[x][y] = map[x][y-- - 1];
        }
        
        // lower
        x = downAirRow;
        y = 0;
        while (x < R - 1) {
            map[x][y] = map[x++ + 1][y];
        }
        while (y < C - 1) {
            map[x][y] = map[x][y++ + 1];
        }
        while (x > downAirRow) {
            map[x][y] = map[x-- - 1][y];
        }
        while (y > 1) {
            map[x][y] = map[x][y-- - 1];
        }
        map[upAirRow][1] = 0;
        map[downAirRow][1] = 0;
        map[upAirRow][0] = 0;
        map[downAirRow][0] = 0;
    }
    
    private static void spreadDust() {
        int[][] spreadResult = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 4) {
                    for (int dr = 0; dr < 4; dr++) {
                        int nx = i + dx[dr];
                        int ny = j + dy[dr];
                        
                        if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                        if (map[nx][ny] == -1) continue;
                        
                        int diff = (int)Math.floor(map[i][j] / 5);
                        spreadResult[nx][ny] += diff;
                        spreadResult[i][j] -= diff;
                    }
                }
            }
        }
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] += spreadResult[i][j];
            }
        }
    }
}