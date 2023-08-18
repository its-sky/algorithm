class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[][] dp = new int[money.length+1][n+1];
        
        for (int i = 1; i < money.length+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j == 0) dp[i][j] = 1;
                else {
                    if (j < money[i - 1]) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = (dp[i - 1][j] + dp[i][j - money[i - 1]]) % 1000000007;
                }
            }
        }
        
        return dp[money.length][n] % 1000000007;
    }
}
// --0 1 2 3 4 5 6 7 8 9 10
// 0 0 0 0 0 0 0 0 0 0 0 0
// 1 1 1 1 1 1 1 1 1 1 1 1
// 2 1 1 2 2 3 3 4 4 5 5 6
// 5 1 1 2 2 3 4 5

// dp[i][j] = dp[i-1][j] + dp[i][j - money[j]]