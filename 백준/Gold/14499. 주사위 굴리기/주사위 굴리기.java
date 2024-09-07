import java.io.*;
import java.util.*;

public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = new int[7];
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            int d = Integer.parseInt(st.nextToken());
            move(d);
        }
    }
    
    static void move(int d) {
        int nx = x + dx[d - 1];
        int ny = y + dy[d - 1];
        if (nx < 0 || ny < 0 || nx >= M || ny >= N) return;
        roll(d, nx, ny);
        x = nx;
        y = ny;
    }
    
    static void roll(int d, int x, int y) {
        int tmp = dice[3];
        switch (d) {
            case 1:
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = tmp;
                break;
            case 4:
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
        }
        if (map[y][x] == 0) {
            map[y][x] = dice[6];
        } else {
            dice[6] = map[y][x];
            map[y][x] = 0;
        }
        System.out.println(dice[3]);
    }
}