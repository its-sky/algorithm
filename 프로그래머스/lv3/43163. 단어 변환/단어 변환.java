import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        answer = words.length;
        boolean is = Arrays.stream(words).anyMatch(target::equals);
        if (!is)
            return 0;
        
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    private void dfs(String now, String target, String[] words, int cnt) {
        if (now.equals(target))
            answer = Math.min(answer, cnt);
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && match(now, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean match(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                ++cnt;
            }
        }
        if (cnt == 1)
            return true;
        return false;
    }
}