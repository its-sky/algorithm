import java.util.*;

class Solution {
    static int size;
    static int[] reserve;
    
    public int solution(int n, int k) {
        int answer = 0;
        int start = 0;
        
        conversion(n, k);
        
        for (int i=0; i<reserve.length; i++) {
            if (reserve[i] == 0) {
                long num = arrToNum(start, i - 1);
                if (isIt(num))
                    ++answer;
                if (i < reserve.length - 1)
                    start = i + 1;
            }
        }
        if (isIt(arrToNum(start, reserve.length-1)))
            ++answer;
        if (answer == 0) {
            if (isIt(arrToNum(0, reserve.length - 1)))
                ++answer;
        }
        
        return answer;
    }
    
    private boolean isIt(long num) {
        if (num == 0 || num == 1)
            return false;
        if (num == 2)
            return true;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    
    private long arrToNum(int start, int end) {
        long num = 0;
        for (int i=start; i<=end; i++) {
            num = num * 10;
            num += reserve[i];
        }
        return num;
    }
    
    private int count(int n, int k) {
        int cnt = 0;
        while (n > 0) {
            n = n / k;
            ++cnt;
        }
        return cnt;
    }
    
    private void conversion(int n, int k) {
        size = count(n, k);
        reserve = new int[size];
        
        for (int i=size-1; i>=0; i--) {
            reserve[i] = n % k;
            n = n / k;
        }
    }
}