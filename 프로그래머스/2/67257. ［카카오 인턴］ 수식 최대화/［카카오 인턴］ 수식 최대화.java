import java.util.*;

class Solution {
    static long res = Long.MIN_VALUE;
    static boolean[] visited;
    static char[] val;
    public long solution(String expression) {
        String[] tmp = expression.split("\\+|-|\\*");
        List<Long> nums = new ArrayList<>();
        for (String num : tmp) {
            nums.add(Long.parseLong(num));
        }
        
        char[] chrs = expression.toCharArray();
        List<Character> ops = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '+' || chrs[i] == '-' || chrs[i] == '*') {
                ops.add(chrs[i]);
                set.add(chrs[i]);
            }
        }
        
        visited = new boolean[set.size()];
        val = new char[set.size()];
        int idx = 0;
        for (Character op : set) {
            val[idx++] = op;
        }
        
        dfs(nums, ops, 0);
        
        return res;
    }
    
    private void dfs(List<Long> nums, List<Character> ops, int depth) {
        if (depth == val.length) {
            res = Math.max(res, Math.abs(nums.get(0)));
            return;
        }
        
        for (int i = 0; i < val.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                List<Long> newNums = new ArrayList<>(nums);
                List<Character> newOps = new ArrayList<>(ops);
                
                for (int j = 0; j < newOps.size(); j++) {
                    if (newOps.get(j) == val[i]) {
                        if (val[i] == '+') {
                            long newValue = newNums.remove(j + 1) + newNums.remove(j);
                            newOps.remove(j);
                            newNums.add(j, newValue);
                            j -= 1;
                        } else if (val[i] == '-') {
                            long val2 = newNums.remove(j + 1);
                            long val1 = newNums.remove(j);
                            long newValue = val1 - val2;
                            newOps.remove(j);
                            newNums.add(j, newValue);
                            j -= 1;
                        } else if (val[i] == '*') {
                            long newValue = newNums.remove(j + 1) * newNums.remove(j);
                            newOps.remove(j);
                            newNums.add(j, newValue);
                            j -= 1;
                        }
                    }
                }
                dfs(newNums, newOps, depth + 1);
                
                visited[i] = false;
            }
        }
    }
}