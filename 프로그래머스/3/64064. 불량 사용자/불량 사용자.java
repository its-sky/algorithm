import java.util.*;

class Solution {
    static boolean[] visited;
    static Set<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        set = new HashSet<>();
        
        dfs(user_id, banned_id, new String[banned_id.length], 0);
        
        return set.size();
    }
    
    private void dfs(String[] user_id, String[] banned_id, String[] tmp, int depth) {
        if (depth == banned_id.length) {
            StringBuilder sb = new StringBuilder();
            Arrays.sort(tmp);
            for (String a : tmp) {
                sb.append(a);
            }
            set.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (visited[i] == false && overlap(banned_id[depth], user_id[i])) {
                visited[i] = true;
                String[] tmp2 = tmp.clone();
                tmp2[depth] = user_id[i];
                dfs(user_id, banned_id, tmp2, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean overlap(String a, String b) {
        if (a.length() != b.length()) return false;
        
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '*') continue;
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
}