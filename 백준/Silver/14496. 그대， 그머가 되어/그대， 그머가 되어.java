import java.io.*;
import java.util.*;

public class Main {
    static int a, b, n, m, res;
    static boolean[] visited;
    static List<List<Integer>> arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.get(s).add(e);
            arr.get(e).add(s);
        }
        br.close();
        
        res = -1;
        bfs(a);
        
        System.out.println(res);
    }
    
    private static void bfs(int start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(start, 0));
        visited[start] = true;
        
        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (curr.x == b) {
                res = Math.max(res, curr.val);
            }
            for (Integer adj : arr.get(curr.x)) {
                if (!visited[adj]) {
                    q.offer(new Point(adj, curr.val + 1));
                    visited[adj] = true;
                }
            }
        }
    }
    
    static class Point {
        int x, val;
        
        public Point(int x, int val) {
            this.x = x;
            this.val = val;
        }
    }
}