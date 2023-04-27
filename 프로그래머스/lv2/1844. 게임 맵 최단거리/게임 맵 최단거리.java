import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static int[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length];
        
        bfs(maps);
        
        answer = visited[maps.length-1][maps[0].length-1];
        if (answer == 0)
            answer = -1;
        
        return answer;
    }
    
    private void bfs(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            x = curr[0];
            y = curr[1];
        
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length - 1)
                    continue;

                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}