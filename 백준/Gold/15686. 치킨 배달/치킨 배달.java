import java.io.*;
import java.util.*;

public class Main {
    static int N, M, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static boolean[] close;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homes.add(new int[]{i, j});
                }
                else if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        br.close();
        
        visited = new boolean[chickens.size()];
        
        dfs(0, 0);
        System.out.println(min);
    }
    
    private static void dfs(int depth, int idx) {
        if (depth == M) {
            int res = 0;

            for (int i = 0; i < homes.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (visited[j]) {
                        int dist = Math.abs(homes.get(i)[0] - chickens.get(j)[0])
                                + Math.abs(homes.get(i)[1] - chickens.get(j)[1]);

                        temp = Math.min(temp, dist);
                    }
                }
                res += temp;
            }
            min = Math.min(min, res);
            return;
        }
        
        for (int i = idx; i < chickens.size(); i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}