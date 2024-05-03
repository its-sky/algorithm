class Solution {
    static int MOD = 1000000007;
    public int solution(int n) {
        int answer = 0;
        
        if (n % 2 != 0) return 0;
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i+=2) {
            dp[i] = (dp[i - 2]*4%MOD - dp[i - 4]%MOD + MOD) % MOD;
        }
        
        return (int)dp[n];
    }
}