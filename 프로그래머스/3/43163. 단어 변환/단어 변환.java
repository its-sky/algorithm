import java.util.*;

class Solution {
    static boolean[] visited;
    static String[] word;
    static int res = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        word = words;
        
        // words안에 target이 없으면 0 반환
        boolean hasTarget = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) hasTarget = true;
        }
        
        if (!hasTarget) return 0;
        
        dfs(begin, target, 0);
        if (res == Integer.MAX_VALUE) return 0;
        return res;
    }
    
    private void dfs(String curr, String target, int depth) {
        if (curr.equals(target)) {
            res = Math.min(res, depth);
            return;
        }
        if (depth == word.length) return;
        
        for (int i = 0; i < word.length; i++) {
            if (isChangable(curr, word[i]) && !visited[i]) {
                visited[i] = true;
                dfs(word[i], target, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean isChangable(String a, String b) {
        int count = 0;
        
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) ++count;
        }
        
        if (count == 1) return true;
        return false;
    }
}