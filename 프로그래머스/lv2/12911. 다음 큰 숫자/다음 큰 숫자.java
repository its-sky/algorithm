class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int nCount = count(n);
        
        int start = n + 1;
        while (true) {
            if (nCount == count(start)) return start;
            ++start;
        }
    }
    
    private int count(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1) ++ res;
            n = n >> 1;
        }
        return res;
    }
}