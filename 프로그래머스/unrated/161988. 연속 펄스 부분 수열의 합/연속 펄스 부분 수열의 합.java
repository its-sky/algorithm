import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        long[][] tmp = new long[2][sequence.length];
        
        for (int i = 0; i < sequence.length; ++i) {
            tmp[0][i] = -1 * sequence[i];
            tmp[1][i] = sequence[i];
        }
        
        for (int i = 1; i < sequence.length; ++i) {
            tmp[0][i] = Math.max(tmp[0][i], tmp[1][i-1]+tmp[0][i]);
            tmp[1][i] = Math.max(tmp[1][i], tmp[0][i-1]+tmp[1][i]);
        }
        
        for (int i = 0; i < sequence.length; ++i) {
            answer = Math.max(answer, Math.max(tmp[0][i], tmp[1][i]));
        }
        
        return answer;
    }
}

// -2 -3  6 -1 -3  1 -2 -4
//  2  3 -6  1  3 -1  2  4
    
// -2 -1  9 -1 7 4 4 2
//  2  3 -6 10 3 6 6 8