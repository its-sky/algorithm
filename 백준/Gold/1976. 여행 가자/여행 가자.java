import java.io.*;
import java.util.*;

public class Main {
    static int N, M, parents[], travel[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String answer = "YES";
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        parents = new int[N + 1];
        travel = new int[M];
        
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int curr = Integer.parseInt(st.nextToken());
                if (curr == 1) {
                    if (i < j) union(i, j);
                    else union(j, i);
                }
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            travel[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < M; i++) {
            if (find(travel[i]) != find(travel[i - 1])) answer = "NO";
        }
        
        System.out.println(answer);
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