import java.io.*;
import java.util.*;

public class Main {
    static int N, count;
    static int[] next, processed;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            count = 0;
            next = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                next[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[N + 1];
            processed = new int[N + 1];
            int step = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    bfs(i, step++);
                }
            }
            System.out.println(N - count);
        }
        br.close();
    }
    
    private static void bfs(int start, int step) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> record = new Stack<>();
        q.offer(start);
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            
            if (!visited[curr]) {
                visited[curr] = true;
                processed[curr] = step;
                record.push(curr);
                q.offer(next[curr]);
            } else {
                if (processed[curr] != step) continue;
                int mode = 0;
                while (true) {
                    int r = record.pop();
                    ++count;
                    if (curr == r) {
                        mode = 1;
                        break;
                    }
                }
                if (mode == 1) break;
            }
        }
    }
}