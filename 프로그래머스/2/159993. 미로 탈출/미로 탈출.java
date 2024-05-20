import java.util.*;

class Solution {
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        int res = 0;
        
        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;
        int exitX = 0, exitY = 0;
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                if (map[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                }
                if (map[i][j] == 'E') {
                    exitX = i;
                    exitY = j;
                }
            }
        }
        
        res += bfs(startX, startY, 'L');
        
        if (!visited[leverX][leverY]) return -1;
        
        visited = new boolean[maps.length][maps[0].length()];
        res += bfs(leverX, leverY, 'E');
        
        if (!visited[exitX][exitY]) return -1;
        
        return res;
    }
    
    private int bfs(int x, int y, char target) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y, 0});
        int count = 0;
        boolean flag = false;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if (map[nx][ny] == 'X') continue;
                
                if (!visited[nx][ny]) {
                    if (map[nx][ny] == target) {
                        visited[nx][ny] = true;
                        count = curr[2] + 1;
                        flag = true;
                        break;
                    } else {
                        ++count;
                        q.offer(new int[]{nx, ny, curr[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
            if (flag) break;
        }
        
        return count;
    }
}