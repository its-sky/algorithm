import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Edge[] edgeList;
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        edgeList = new Edge[M + 1];
        dist = new long[N + 1];
        
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(start, end, w);
        }
        br.close();
        
        dist[1] = 0;
        for (int i = 2; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i <= N - 1; i++) {
            updateDistance();
        }
        
        long[] lastDist = dist.clone();
        
        for (int i = 1; i <= N - 1; i++) {
            updateDistance();
        }
        
        for (int i = 2; i <= N; i++) {
            if (lastDist[i] != dist[i]) {
                System.out.println(-1);
                return;
            }
        }
        
        for (int i = 2; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
                continue;
            }
            System.out.println(dist[i]);
        }
    }
    
    private static void updateDistance() {
        for (int i = 1; i <= M; i++) {
            int S = edgeList[i].start;
            int E = edgeList[i].end;
            int W = edgeList[i].w;
            
            if (dist[S] != Integer.MAX_VALUE && dist[E] > dist[S] + W) {
                dist[E] = dist[S] + W;
            }
        }
    }
    
    static class Edge {
        int start, end, w;
        
        public Edge(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }
    }
}