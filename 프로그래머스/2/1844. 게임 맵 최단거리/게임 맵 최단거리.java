import java.util.*;

class Solution {
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        for (int i = 0; i < maps.length; i++) {
            Arrays.fill(visited[i], -1);
        }
        
        visited[0][0] = 1;
        bfs(maps);
        
        if (visited[maps.length - 1][maps[0].length - 1] == -1) {
            return -1;
        }
        
        return visited[maps.length - 1][maps[0].length - 1];
    }
    
    private void bfs(int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        
        while (!q.isEmpty()) {
            Point curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if (nx < 0 || nx >= visited.length || ny < 0 || ny >= visited[0].length) continue;
                
                if (maps[nx][ny] == 1 && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[curr.x][curr.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
    
    static class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
}