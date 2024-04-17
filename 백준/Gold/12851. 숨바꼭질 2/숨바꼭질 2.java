import java.io.*;
import java.util.*;

public class Main {
    static int N, K, time, cnt;
    static int[] visited = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        br.close();
        
        bfs();
        
        System.out.println(time + "\n" + cnt);
    }
    
    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(N, 0));
        visited[N] = 1;
        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (curr.val == K) {
                if (cnt == 0) time = curr.time;
                if (time == curr.time) ++cnt;
                continue;
            }
            int[] arr = {curr.val-1,curr.val+1,curr.val*2};
            for (int i = 0; i < 3; i++) {
                int next = arr[i];
                if (next < 0 || next > 100000) continue;
                if (visited[next] == 0 || visited[next] == curr.time + 1) {
                    visited[next] = curr.time + 1;
                    q.offer(new Point(next, curr.time + 1));
                }
            }
        }
    }
    
    static class Point {
        int time, val;
        
        public Point(int val, int time) {
            this.time = time;
            this.val = val;
        }
    }
}