import java.util.*;

class Solution {
    static int[] discount;
    static int plus = 0;
    static int total = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        discount = new int[emoticons.length];
        
        dfs(0, users, emoticons);
        
        int[] arr = new int[2];
        arr[0] = plus;
        arr[1] = total;
        
        return arr;
    }
    
    private void dfs(int depth, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            int tmp_plus = 0;
            int tmp_total = 0;
            int tmp = 0;
            for (int[] user : users) {
                tmp = 0;
                for (int i = 0; i < discount.length; i++) {
                    if (discount[i] >= user[0])
                        tmp += (int)(emoticons[i] * (100 - discount[i]) / 100);
                }
                if (tmp >= user[1]) {
                    ++tmp_plus;
                } else {
                    tmp_total += tmp;
                }
            }
            
            if (tmp_plus > plus) {
                plus = tmp_plus;
                total = tmp_total;
            } else if (tmp_plus == plus && tmp_total > total) {
                total = tmp_total;
            }
            return ;
        }
        
        for (int i = 0; i < 4; i++) {
            discount[depth] = 10 * (i + 1);
            dfs(depth + 1, users, emoticons);
        }
    }
}