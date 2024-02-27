import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        int[][][] map = new int[N][3][2];
        StringTokenizer st;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
                map[i][j][1] = map[i][j][0];
            }
        }
        br.close();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                for (int k = -1; k <= 1; k++) {
                    if (j + k < 0 || j + k > 2) continue;
                    max = Math.max(max, map[i-1][j+k][0]);
                    min = Math.min(min, map[i-1][j+k][1]);
                }
                map[i][j][0] += max;
                map[i][j][1] += min;
            }
        }
        
        int resMax = Math.max(map[N-1][0][0], Math.max(map[N-1][1][0], map[N-1][2][0]));
        int resMin = Math.min(map[N-1][0][1], Math.min(map[N-1][1][1], map[N-1][2][1]));
        System.out.println(resMax + " " + resMin);
    }
}