import java.util.*;

class Solution {
    static int[] count, dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static boolean[][] visited;
    public int solution(int[][] land) {
        count = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    bfs(i, j, land);
                }
            }
        }
        
        int res = -1;
        
        for (int i = 0; i < land[0].length; i++) {
            res = Math.max(res, count[i]);
        }
        
        return res;
    }
    
    private static void bfs(int x, int y, int[][] land) {
        Set<Integer> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        set.add(y);
        int total = 1;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if (nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length) continue;
                
                if (!visited[nx][ny] && land[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    set.add(ny);
                    ++total;
                }
            }
        }
        
        for (int tmp : set) {
            count[tmp] += total;
        }
    }
}

// Set을 사용해서 column 넣어두기
// BFS로 몇칸인지 체크하고 array 해당 column에 bfs 값 더해두기