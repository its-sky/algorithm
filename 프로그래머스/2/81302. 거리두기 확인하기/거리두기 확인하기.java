import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public int[] solution(String[][] places) {
        int[] res = new int[5];
        
        Arrays.fill(res, 1);
        
        for (int p = 0; p < places.length; p++) {
            boolean isNotSeparated = false;
            int size = 0;
            int flag = -1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (places[p][i].charAt(j) == 'P') {
                        boolean[][] visited = new boolean[5][5];
                        isNotSeparated = bfs(i, j, places[p], visited);
                        if (isNotSeparated) {
                            res[p] = 0;
                            flag = 1;
                        }
                    }
                    if (flag == 1) break;
                }
                if (flag == 1) break;
            }
        }
        
        return res;
    }
    
    private static boolean bfs(int x, int y, String[] place, boolean[][] visited) {
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{x, y});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            Integer[] curr = q.poll();
            
            if (Math.abs(curr[0] - x) + Math.abs(curr[1] - y) >= 2) {
                return false;
            }
            
            for (int j = 0; j < 4; j++) {
                int nx = curr[0] + dx[j];
                int ny = curr[1] + dy[j];
                
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                
                if (!visited[nx][ny] && place[nx].charAt(ny) != 'X') {
                    if (place[nx].charAt(ny) == 'P') return true;
                    q.offer(new Integer[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return false;
    }
}

// P일때 bfs를 돌리는데 for문 2번 돌려서 P를 만나면 격리가 잘 안되고 있는걸로 판단