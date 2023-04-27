class Solution {
    static int answer = 0;
    static int tar = 0;
    static boolean[] visited;
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        tar = target;
        
        dfs(0, 0, numbers);
        
        return answer;
    }
    
    private void dfs(int depth, int now, int[] numbers) {
        if (depth == numbers.length) {
            if (now == tar)
                ++answer;
            return;
        }
        dfs(depth + 1, now + numbers[depth], numbers);
        dfs(depth + 1, now - numbers[depth], numbers);
    }
}