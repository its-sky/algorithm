import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (o1, o2) -> {
           return o1[col-1] != o2[col-1] ? o1[col-1] - o2[col-1] : o2[0] - o1[0]; 
        });
        
        for (int i = row_begin - 1; i < row_end; i++) {
            int tmp = 0;
            for(int target : data[i]) {
                tmp += target % (i + 1);
            }
            answer = answer ^ tmp;
        }
        
        return answer;
    }
}