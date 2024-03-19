import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[] indegree = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        
        List<List<Integer>> arr = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            indegree[b] += 1;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }
        
        while (!pq.isEmpty()) {
            Integer curr = pq.poll();
            res.add(curr);
            
            for (Integer adj : arr.get(curr)) {
                indegree[adj] -= 1;
                
                if (indegree[adj] == 0) {
                    pq.add(adj);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if (res.size() >= 1) {
            sb.append(res.get(0));
        }
        
        if (res.size() >= 2) {
            for (int i = 1; i < res.size(); i++) {
                sb.append(" ");
                sb.append(res.get(i));
            }
        }
        
        System.out.println(sb);
        br.close();
    }
}