import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        int maxSize = Integer.MIN_VALUE;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    maxSize = Math.max(maxSize, bfs(i, j, picture, visited));
                    ++count;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = maxSize;
        return answer;
    }
    
    private int bfs(int x, int y, int[][] picture, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        int cnt = 1;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) continue;

                if (picture[x][y] == picture[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    ++cnt;
                }
            }
        }
        
        return cnt;
    }
    
}

// 1110
// 1220
// 1001
// 0001
// 0003
// 0003