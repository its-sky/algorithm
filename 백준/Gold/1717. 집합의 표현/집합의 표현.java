import java.io.*;
import java.util.*;

public class Main {
    static int N, M, parents[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b) {
                int tmp = b;
                b = a;
                a = tmp;
            }
            
            if (cmd == 0) {
                union(a, b);
            } else {
                System.out.println(find(a) != find(b) ? "NO" : "YES");
            }
        }
    }
    
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        
        if (aRoot == bRoot) return;
        parents[bRoot] = aRoot;
    }
    
    private static int find(int n) {
        if (n == parents[n]) return n;
        return parents[n] = find(parents[n]);
    }
}