import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < diffs.length; i++) {
            right = Math.max(right, diffs[i]);
        }
        
        while (left <= right) {
            int level = (left + right) / 2;
            long time = getTotalTime(diffs, times, level);
            
            if (time == limit) {
                return level;
            } else if (time < limit) {
                long nextTime = level == 1 ? (limit + 1) : getTotalTime(diffs, times, level - 1);
                
                if (limit < nextTime) {
                    return level;
                } else {
                    right = level - 1;
                }
            } else {
                left = level + 1;
            }
        }
        
        return -1;
    }
    
    private static long getTotalTime(int[] diffs, int[] times, int level) {
        long totalTime = 0;
            
        for (int idx = 0; idx < diffs.length; idx++) {
            totalTime += getSpentTime(diffs, times, idx, level);
        }
        return totalTime;
    }
    
    private static int getSpentTime(int[] diffs, int[] times, int idx, int level) { 
        if (diffs[idx] <= level) {
            return times[idx];
        }
        return (times[idx] + times[idx - 1]) * (diffs[idx] - level) + times[idx];
    }
}