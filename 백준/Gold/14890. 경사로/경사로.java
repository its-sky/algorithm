import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static int[][] map;
    static int[] arr;
    static boolean[] staired;
    static int[] dx = {1, 0}, dy = {0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        
        int result = 0;
        
        for (int i = 0; i < N; i++) {
            // 세로
            place(0, i, 0);
            staired = new boolean[N];
            if (check()) {
                ++result;
            }
            
            // 가로
            place(i, 0, 1);
            staired = new boolean[N];
            if (check()) {
                ++result;
            }
        }
        
        System.out.println(result);
    }
    
    private static void place(int x, int y, int dr) {
        int idx = 0;
        while (true) {
            if (x < 0 || y < 0 || x >= N || y >= N) break;
            arr[idx++] = map[x][y];
            x = x + dx[dr];
            y = y + dy[dr];
        }
    }
    
    private static boolean check() {
        int idx = 0;
        boolean flag = true;
        
        while (idx < N - 1) {
            int gap = arr[idx + 1] - arr[idx];
            
            if (gap == -1) {
                // 다음으로 L개 체크
                if (!checkStair(idx + 1, 1)) {
                    flag = false;
                    break;
                }
            } else if (gap == 1) {
                // 현재부터 이전으로 L개 체크
                if (!checkStair(idx, -1)) {
                    flag = false;
                    break;
                }
            } else if (gap >= 2 || gap <= -2) {
                flag = false;
                break;
            }
            ++idx;
        }
        
        return flag;
    }
    
    private static boolean checkStair(int idx, int dr) {
        // dr == 1 순방향, dr == -1 역방향
        boolean flag = true;
        int tmpIdx = idx;
        int value = arr[idx];
        int count = 0;
        
        while (count < L) {
            if (idx < 0 || idx >= N) {
                flag = false;
                break;
            }
            if (staired[idx] || value != arr[idx]) {
                flag = false;
                break;
            }
            idx += dr;
            ++count;
        }
        
        if (flag) {
            placeStair(tmpIdx, dr);
        }
        return flag;
    }
    
    private static void placeStair(int idx, int dr) {
        for (int i = 0; i < L; i++) {
            staired[idx] = true;
            idx += dr;
        }
    }
}