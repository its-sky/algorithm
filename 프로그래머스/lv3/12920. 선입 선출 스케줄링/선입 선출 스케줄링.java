class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        
        int min = 0;
        int max = cores[0]*n;
        
        int time = 0;
        int m = 0;
        
        while (min <= max) {
            int mid = (min + max) / 2;
            
            int count = Work(mid, cores);
            
            if (count >= n) {
                max = mid - 1;
                time = mid;
                m = count;
            } else {
                min = mid + 1;
            }
        }
        
        m -= n;
        for (int i = cores.length - 1; i >= 0; i--) {
            if (time % cores[i] == 0) {
                if (m == 0) {
                    answer = i + 1;
                    break;
                }
                --m;
            }
        }
        
        return answer;
    }
    
    private int Work(int time, int[] cores) {
        if (time == 0) return cores.length;
        
        int count = cores.length;
        
        for (int i = 0; i < cores.length; i++) {
            count += (time / cores[i]);
        }
        
        return count;
    }
}
// 1 2 1 3 1 2