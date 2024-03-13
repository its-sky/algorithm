import java.io.*;
import java.util.*;

public class Main {
    static int N, res;
    static int[] dice;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        dice = new int[6];
        
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        
        res = Integer.MAX_VALUE;
        visited = new boolean[6];
        // 2개짜리 최소 구하기
        dfs(0, 0, 2);
        int two = res;
        
        res = Integer.MAX_VALUE;
        visited = new boolean[6];
        // 3개짜리 최소 구하기
        dfs(0, 0, 3);
        int three = res;
        
        long total = N*N*5;
        long oneCnt = 5L * (N-2)*(N-2) + 4L * (N-2);
        long twoCnt = 8L*(N-2) + 4;
        long threeCnt = 4;
        
        Arrays.sort(dice);
        if (N == 1) {
            System.out.println(dice[0] + dice[1] + dice[2] + dice[3] + dice[4]);
        } else {
            System.out.println(
                threeCnt*three + twoCnt*two + oneCnt * dice[0]
            );
        }
    }
    
    private static void dfs(int curr, int depth, int max) {
        if (depth == max) {
            // 여기서 res에 결과값 담기
            res = Math.min(res, curr);
            return;
        }
        
        for (int i = 0; i < 6; i++) {
            if (!visited[i] && !visited[5 - i]) {
                visited[i] = true;
                dfs(curr + dice[i], depth + 1, max);
                visited[i] = false;
            }
        }
    }
}