import java.util.*;

class Solution {
    static int[] visited;
    static int max = 0;
    static List<List<Integer>> adj;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new int[n + 1];
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        bfs();
        
        for (int i = 1; i <= n; i++) {
            if (max == visited[i]) {
                ++answer;
            }
        }
        
        return answer;
    }
    
    private void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = 1;
        
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            for (Integer n : adj.get(curr)) {
                if (visited[n] == 0) {
                    visited[n] = visited[curr] + 1;
                    max = Math.max(max, visited[n]);
                    q.offer(n);
                }
            }
        }
    }
}