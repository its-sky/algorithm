import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            
            d = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }
            
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                list.add(new ArrayList<>());
            }
            
            int[] indegree = new int[N + 1];
            
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                ++indegree[b];
            }
            
            int target = Integer.parseInt(br.readLine());
            
            topologicalSort(indegree, list, target);
        }
        br.close();
    }
    
    private static void topologicalSort(int[] indegree, List<List<Integer>> list, int target) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            result[i] = d[i];
            
            if (indegree[i] == 0) q.offer(i);
        }
        
        while (!q.isEmpty()) {
            int node = q.poll();
            
            for (Integer i : list.get(node)) {
                result[i] = Math.max(result[i], result[node] + d[i]);
                --indegree[i];
                
                if (indegree[i] == 0) q.offer(i);
            }
        }
        
        System.out.println(result[target]);
    }
    
}