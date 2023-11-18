import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for (int item : queue1) {
            q1.offer(item);
            sum1 += item;
        }
        for (int item : queue2) {
            q2.offer(item);
            sum2 += item;
        }
        
        int cnt = 0;
        int item = 0;
        
        while (sum1 != sum2) {
            if(cnt > (q1.size() + q2.size()) * 2)
                return -1;
            if (sum1 < sum2) {
                item = q2.poll();
                q1.offer(item);
                sum1 += item;
                sum2 -= item;
            } else {
                item = q1.poll();
                q2.offer(item);
                sum1 -= item;
                sum2 += item;
            }
            ++cnt;
        }
        
        return cnt;
    }
}