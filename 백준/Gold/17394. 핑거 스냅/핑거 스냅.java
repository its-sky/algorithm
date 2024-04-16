import java.io.*;
import java.util.*;

public class Main {
    static int res = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            res = -1;
            
            bfs(N, a, b);
            sb.append(res).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
    
    private static void bfs(int N, int a, int b) {
        Queue<Check> q = new LinkedList<>();
        boolean[] visited = new boolean[1_000_002];
        q.offer(new Check(N, 0));
        visited[N] = true;
        
        while (!q.isEmpty()) {
            Check curr = q.poll();
            
            if (curr.n >= a && curr.n <= b) {
                if (validate(curr.n)) {
                    res = curr.val;
                    break;
                }
            }
            
            if (!visited[(int)Math.floor(curr.n / 2)] && (int)Math.floor(curr.n / 2) >= 2) {
                q.offer(new Check((int)Math.floor(curr.n / 2), curr.val + 1));
                visited[(int)Math.floor(curr.n / 2)] = true;
            }
            if (!visited[(int)Math.floor(curr.n / 3)] && (int)Math.floor(curr.n / 3) >= 2) {
                q.offer(new Check((int)Math.floor(curr.n / 3), curr.val + 1));
                visited[(int)Math.floor(curr.n / 3)] = true;
            }
            if (!visited[curr.n + 1] && curr.n + 1 <= 100000) {
                q.offer(new Check(curr.n + 1, curr.val + 1));
                visited[curr.n + 1] = true;
            }
            if (!visited[curr.n - 1] && curr.n - 1 >= 2) {
                q.offer(new Check(curr.n - 1, curr.val + 1));
                visited[curr.n - 1] = true;
            }
        }
    }
    
    private static boolean validate(int N) {
        int target = (int)Math.sqrt(N);
        
        for (int i = 2; i <= target; i++) {
            if (N % i == 0) return false;
        }
        return true;
    }
    
    static class Check {
        int n, val;
        
        public Check(int n, int val) {
            this.n = n;
            this.val = val;
        }
    }
}