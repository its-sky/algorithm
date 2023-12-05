class Solution {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    
    public int solution(String[][] board, int h, int w) {
        return countAdj(board, h, w);
    }
    
    private static int countAdj(String[][] board, int h, int w) {
        int count = 0;
        
        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                continue;
            }
            
            if (board[nx][ny].equals(board[h][w])) ++count;
        }
        
        return count;
    }
}