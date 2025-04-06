import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] visitOrder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        visitOrder = new int[N];
        
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitOrder[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        
        boolean check = checkBfs();
        
        if (visitOrder[0] != 1) {
            check = false;
        }
        
        System.out.println(check ? 1 : 0);
    }
    
    private static boolean checkBfs() {
        Queue<Integer> q = new LinkedList<>();
        int parent = 1;
        visited[parent] = true;
        q.offer(parent);
        int count = 1;
        
        while (!q.isEmpty()) {
            parent = q.poll();
            int childCount = 0;
            
            for (int child : graph.get(parent)) {
                if (!visited[child]) {
                    visited[child] = true;
                    ++childCount;
                }
            }
            
            for (int i = count; i < count + childCount && i < N; i++) {
                if (!visited[visitOrder[i]]) {
                    return false;
                } else {
                    q.offer(visitOrder[i]);
                }
            }
            count += childCount;
        }
        return true;
    }
}