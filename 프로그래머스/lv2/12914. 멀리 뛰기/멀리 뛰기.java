class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] res = new long[n + 1];
        res[1] = 1l;
        if (n > 1)
            res[2] = 2l;
        for (int i = 3; i <= n; i++) {
            res[i] = (res[i - 1] + res[i - 2]) % 1234567l;
        }
        
        return res[n] % 1234567l;
    }
}