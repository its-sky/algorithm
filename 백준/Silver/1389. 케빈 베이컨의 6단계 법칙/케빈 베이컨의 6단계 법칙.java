import java.io.*;
import java.util.*;

public class Main {
    static int N, M, INF = 987654321;
    static int[][] bacon;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        bacon = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bacon[i][j] = INF;
                if (i == j) {
                    bacon[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bacon[a][b] = 1;
            bacon[b][a] = 1;
        }
        
        floyd();
        
        int res = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 1; i <= N; i++) {
            int total = sum(bacon[i]);
            if (total < res) {
                res = total;
                idx = i;
            }
        }
        System.out.println(idx);
        br.close();
    }
    
    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    bacon[i][j] = Math.min(bacon[i][j], bacon[i][k] + bacon[k][j]);
                }
            }
        }
    }
    
    private static int sum(int[] targets) {
        int res = 0;
        for (int i = 0; i < targets.length; i++) {
            res += targets[i];
        }
        return res;
    }
}