import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[102][102];
        visited = new boolean[102][102];
        
        for (int[] rec : rectangle) {
            paint(rec[0], rec[1], rec[2], rec[3]);
        }
        
        for (int[] rec : rectangle) {
            remove(rec[0], rec[1], rec[2], rec[3]);
        }
        
        return traversal(characterX*2, characterY*2, itemX*2, itemY*2);
    }
    
    private int traversal(int cX, int cY, int iX, int iY) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(cX, cY, 0));
        visited[cX][cY] = true;
        int res = 0;
        
        while (!q.isEmpty()) {
            Point curr = q.poll();
            
            if (curr.x == iX && curr.y == iY) {
                res = curr.val / 2;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                if (nx < 0 || nx >= 102 || ny < 0 || ny >= 102) continue;
                
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, curr.val + 1));
                }
            }
        }
        
        return res;
    }
    
    private void paint(int start_x, int start_y, int end_x, int end_y) {
        start_x = start_x * 2;
        start_y = start_y * 2;
        end_x = end_x * 2;
        end_y = end_y * 2;
        
        for (int i = start_x; i <= end_x; i++) {
            for (int j = start_y; j <= end_y; j++) {
                map[i][j] = 1;
            }
        }
    }
    
    private void remove(int start_x, int start_y, int end_x, int end_y) {
        start_x = start_x * 2 + 1;
        start_y = start_y * 2 + 1;
        end_x = end_x * 2 - 1;
        end_y = end_y * 2 - 1;
        
        for (int i = start_x; i <= end_x; i++) {
            for (int j = start_y; j <= end_y; j++) {
                map[i][j] = 0;
            }
        }
    }
    
    static class Point {
        int x, y, val;
        
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}