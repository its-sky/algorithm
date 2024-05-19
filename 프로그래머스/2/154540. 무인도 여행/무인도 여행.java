import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public int[] solution(String[] maps) {
        List<Integer> res = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];
        char[][] map = new char[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    res.add(bfs(i, j, map));
                }
            }
        }
        if (res.size() == 0) {
            return new int[]{-1};
        }
        
        Collections.sort(res);
        int[] answer = new int[res.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
    
    private int bfs(int x, int y, char[][] map) {
        int count = map[x][y] - '0';
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                
                if (map[nx][ny] != 'X' && !visited[nx][ny]) {
                    count += map[nx][ny] - '0';
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return count;
    }
}