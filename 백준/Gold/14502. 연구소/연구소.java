import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int max = 0;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> virus = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }
        br.close();
        
        dfs(0);
        
        System.out.println(max);
    }
    
    private static void dfs(int wallCnt) {
        //벽이 3개가 설치 된 경우 bfs 탐색 시작
        if(wallCnt == 3) {
            bfs();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    private static int[][] copyMap() {
        int[][] copiedMap = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copiedMap[i][j] = map[i][j];
            }
        }
        return copiedMap;
    }
    
    private static void bfs() {
        int[][] copiedMap = copyMap();
        visited = new boolean[N][M];
        int count = 0;
        for (int[] pos : virus) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(pos);
            
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                
                for (int i = 0; i < 4; i++) {
                    int nx = curr[0] + dx[i];
                    int ny = curr[1] + dy[i];
                    
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        copiedMap[nx][ny] = 2;
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && copiedMap[i][j] == 0) {
                    ++count;
                }
            }
        }
        
        max = Math.max(max, count);
    }
}