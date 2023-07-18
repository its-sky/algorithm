import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < arr1.length; ++i) {
            int cal = arr1[i] | arr2[i];
            String tmp = Integer.toBinaryString(cal);
            while (n > tmp.length()) {
                tmp = "0" + tmp;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                if (tmp.charAt(j) == '1')
                    sb.append("#");
                else
                    sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}