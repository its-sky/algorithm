import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int count = 1;
        for (int i=1; i<=s.length()/2; ++i) {
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i);
            for (int j = i; j <= s.length(); j+=i) {
                int endIdx = Math.min(j + i, s.length());
                String compare = s.substring(j, endIdx);
                if (base.equals(compare))
                    ++count;
                else {
                    if (count >= 2)
                        sb.append(count);
                    sb.append(base);
                    base = compare;
                    count = 1;
                }
            }
            sb.append(base);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}