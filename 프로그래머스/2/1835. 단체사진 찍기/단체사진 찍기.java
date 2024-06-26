import java.util.*;

class Solution {
    static int answer;
    static String[] arr = {"A", "C", "F", "J", "M", "N", "R", "T"};
    public int solution(int n, String[] data) {
        boolean[] visited = new boolean[8];
        answer = 0;
        dfs("", visited, data);
        return answer;
    }
    
    static void dfs(String orders, boolean[] visited, String[] data) {
        if (orders.length() == 8) {
            if (check(orders, data)) {
                ++answer;
            }
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String order = orders + arr[i];
                dfs(order, visited, data);
                visited[i] = false;
            }
        }
    }
    
    static boolean check(String orders, String[] data) {
        for (String s : data) {
            int first = orders.indexOf(s.charAt(0));
            int second = orders.indexOf(s.charAt(2));
            char op = s.charAt(3);
            int length = Integer.parseInt(String.valueOf(s.charAt(4)));
            if (op == '=') {
                if (!(Math.abs(first - second) - 1 == length)) return false;
            } else if (op == '>') {
                if (!(Math.abs(first - second) - 1 > length)) return false;
            } else if (op == '<') {
                if (!(Math.abs(first - second) - 1 < length)) return false;
            }
        }
        return true;
    }
}