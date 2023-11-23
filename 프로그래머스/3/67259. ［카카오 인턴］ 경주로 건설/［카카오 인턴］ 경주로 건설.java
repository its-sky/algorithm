import java.util.*;

class Solution {
    static int[][][] dp;
    static int[] dx = {0, -1, 1, 0}, dy = {-1, 0, 0, 1};
    static int N;
    static int answer;
    
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        N = board.length;
        dp = new int[N][N][4];
        
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < 4; k++)
                    dp[i][j][k] = Integer.MAX_VALUE;
        
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;
        dp[0][0][3] = 0;
        
        bfs(0, 0, board);
        
        return answer;
    }
    
    private void bfs(int x, int y, int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            x = pos[0]; y = pos[1];
            int preDir = pos[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (board[nx][ny] == 1) continue;
                
                int newCost = dp[x][y][preDir];
                if ((x == 0 && y == 0) || i == preDir) {
                    newCost += 100;
                } else {
                    newCost += 600;
                }
                
                if (dp[nx][ny][i] >= newCost) {
                    dp[nx][ny][i] = newCost;
                    q.offer(new int[]{nx, ny, i});
                    if (nx == N-1 && ny == N-1) {
                        answer = Math.min(newCost, answer);
                    }
                }
            }
        }
    }
}

// 그 전에 어느 direction에서 왔는지를 적어두고 있으면 됨
// 그리고 cost계산할 때 이미 visit이 되어 있을 때 Min값으로 업데이트 해야 할 듯? -> 추가 검증 필요함
// cost가 같은 경우에 방향이 꺾이는걸 말고 직선인걸 어떻게 처리하지?