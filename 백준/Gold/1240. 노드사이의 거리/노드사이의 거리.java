import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] distance, node;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        node = new int[N + 1][N + 1];
        distance = new int[N + 1][N + 1];
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            node[a][b] = 1;
            node[b][a] = 1;
            distance[a][b] = w;
            distance[b][a] = w;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bfs(a, b);
        }
    }
    
    public static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N + 1];
        
        visited[start] = true;
        q.offer(start);
        int[] ans = new int[N + 1];
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int i = 1; i <= N; i++) {
                if (node[curr][i] == 1 && !visited[i]) {
                    ans[i] += distance[curr][i] + ans[curr];
                
                    if (i == end) {
                        System.out.println(ans[end]);
                        return;
                    }
                    
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}