import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res;
    static int[][] map;
    static boolean[] used;
    static int[][] checked;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = 0;
        map = new int[N][M];
        checked = new int[N][M];
        int obs = 0;
        List<int[]> cctvs = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new int[]{i, j});
                }
                if (map[i][j] == 6) ++obs;
            }
        }
        
        alg(0, 0, cctvs);
        
        System.out.println(N*M - res - obs - cctvs.size());
    }
    
    private static void alg(int count, int depth, List<int[]> cctvs) {
        if (depth == cctvs.size()) {
            res = Math.max(res, count);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int tmp = 0;
            int[] cctv = cctvs.get(depth);
            int x = cctv[0];
            int y = cctv[1];
            
            if (map[x][y] == 2) {
                if (i > 1) break;
            } else if (map[x][y] == 5) {
                if (i > 0) break;
            }
            
            switch(map[x][y]) {
                case 1:
                    tmp = countSpace(x, y, i);
                    break;
                case 2:
                    tmp = countSpace(x, y, i) + countSpace(x, y, i + 2);
                    break;
                case 3:
                    tmp = countSpace(x, y, i) + countSpace(x, y, (i + 1) % 4);
                    break;
                case 4:
                    tmp = countSpace(x, y, i) + countSpace(x, y, (i + 1) % 4) + countSpace(x, y, (i + 2) % 4);
                    break;
                case 5:
                    tmp = countSpace(x, y, 0) + countSpace(x, y, 1) + countSpace(x, y, 2) + countSpace(x, y, 3);
                    break;
            }
            
            alg(count + tmp, depth + 1, cctvs);
            
            switch(map[x][y]) {
                case 1:
                    uncheckSpace(x, y, i);
                    break;
                case 2:
                    uncheckSpace(x, y, i);
                    uncheckSpace(x, y, i + 2);
                    break;
                case 3:
                    uncheckSpace(x, y, i);
                    uncheckSpace(x, y, (i + 1) % 4);
                    break;
                case 4:
                    uncheckSpace(x, y, i);
                    uncheckSpace(x, y, (i + 1) % 4);
                    uncheckSpace(x, y, (i + 2) % 4);
                    break;
                case 5:
                    uncheckSpace(x, y, 0);
                    uncheckSpace(x, y, 1);
                    uncheckSpace(x, y, 2);
                    uncheckSpace(x, y, 3);
                    break;
            }
        }
    }
    
    private static int countSpace(int x, int y, int dr) {
        int tmp = 0;
        while (true) {
            x += dx[dr];
            y += dy[dr];
            if (x < 0 || x >= N || y < 0 || y >= M) break;
            if (map[x][y] == 6) {
                break;
            } else if (map[x][y] >= 1 && map[x][y] <= 5) {
                continue;
            }
            if (checked[x][y] == 0) {
                ++tmp;
            }
            checked[x][y] += 1;
        }
        
        return tmp;
    }
    
    private static void uncheckSpace(int x, int y, int dr) {
        while (true) {
            x += dx[dr];
            y += dy[dr];
            if (x < 0 || x >= N || y < 0 || y >= M) break;
            if (map[x][y] == 6) {
                break;
            } else if (map[x][y] >= 1 && map[x][y] <= 5) {
                continue;
            }
            checked[x][y] -= 1;
        }
    }
}
