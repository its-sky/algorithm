import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> record = new ArrayList<>();
        record.add(k);
        
        while (k != 1) {
            if (k % 2 == 0) {
                k = k / 2;
            } else {
                k = k*3 + 1;
            }
            record.add(k);
        }
        
        double[] arr = new double[record.size()];
        for (int i = 1; i < record.size(); i++) {
            arr[i] = arr[i - 1] + ((double)record.get(i) + (double)record.get(i - 1)) / 2.0;
        }
        
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = arr.length + ranges[i][1] - 1;
            
            if (a > b) {
                answer[i] = -1.0;
                continue;
            }
            answer[i] = arr[b] - arr[a];
        }
        
        
        return answer;
    }
}

// 구간합 문제
// 3 10 5 16 8 4 2 1