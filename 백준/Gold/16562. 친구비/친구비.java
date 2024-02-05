import java.io.*;
import java.util.*;

public class Main {
    static int N, M, k;
    static int[] cost;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        cost = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int aParentIdx = findParent(a);
            int bParentIdx = findParent(b);
            if (cost[aParentIdx] <= cost[bParentIdx]) {
                parent[bParentIdx] = aParentIdx;
            } else {
                parent[aParentIdx] = bParentIdx;
            }
        }
        
        int totalCost = 0;
        for (int i = 1; i <= N; i++) {
            int parentIdx = findParent(i);
            if (!visited[parentIdx]) {
                totalCost += cost[parentIdx];
                visited[parentIdx] = true;
            }
        }
        if (k >= totalCost) {
            System.out.println(totalCost);
        } else {
            System.out.println("Oh no");
        }
        br.close();
    }
    
    private static int findParent(int idx) {
        while (parent[idx] != idx) {
            return findParent(parent[idx]);
        }
        return idx;
    }
}