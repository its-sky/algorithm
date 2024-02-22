import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                ++res;
            }
        }
        
        return res;
    }
    
    private void bfs(int idx, int[][] com) {
        Queue<Integer> q = new LinkedList<>();
        visited[idx] = true;
        q.offer(idx);
        
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            
            for (int i = 0; i < com.length; i++) {
                if (i == curr) continue;
                if (!visited[i] && com[curr][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
               }
            }
        }
        
    }
    
    // [1, 1, 0]
    // [1, 1, 0]
    // [0, 0, 1]
}