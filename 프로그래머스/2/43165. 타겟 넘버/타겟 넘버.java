class Solution {
    static int res = 0;
    static int tar;
    public int solution(int[] numbers, int target) {
        tar = target;
        dfs(1, numbers[0], numbers);
        dfs(1, -1*numbers[0], numbers);
        
        return res;
    }
    
    private void dfs(int idx, int num, int[] numbers) {
        if (idx == numbers.length) {
            if (num == tar) {
                ++res;
            }
            return;
        }
        
        dfs(idx + 1, num + numbers[idx], numbers);
        dfs(idx + 1, num - numbers[idx], numbers);
    }
}