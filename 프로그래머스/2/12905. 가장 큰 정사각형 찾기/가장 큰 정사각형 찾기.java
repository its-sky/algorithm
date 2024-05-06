class Solution
{
    public int solution(int [][]board)
    {
        if (board.length < 3 && board[0].length < 3) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 1) return 1;
                }
            }
            return 0;
        }
        
        int[][] dp = new int[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 1) dp[i][0] = 1;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 1) dp[0][i] = 1;
        }
        
        int maxSize = 0;
        
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 0) continue;
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }

        return maxSize * maxSize;
    }
}