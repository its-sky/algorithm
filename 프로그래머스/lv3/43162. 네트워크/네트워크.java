class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        int answer = 0;
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                ++answer;
                dfs(i, computers);
            }
        }
        
        return answer;
    }
    
    private void dfs(int now, int[][] computers) {
        visited[now] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[now][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}