import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int s = (int)begin;
        int e = (int)end;
        int[] answer = new int[e - s + 1];
        
        int cnt = 0;
        for (int i = s; i <= e; i++) {
            answer[cnt++] = calculate(i);
        }
        
        if (s == 1) answer[0] = 0;
        
        return answer;
    }
    
    private int calculate(int num) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                list.add(i);
                if (num / i <= 10000000) {
                    return num / i;
                }
            }
        }
        
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        }
        
        return 1;
    }
}