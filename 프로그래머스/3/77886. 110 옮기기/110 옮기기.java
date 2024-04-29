import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for (int i = 0; i < s.length; i++) {
            Stack<Character> stack = new Stack<>();
            String str = s[i];
            int count = 0;
            
            for (int j = 0; j < str.length(); j++) {
                stack.push(str.charAt(j));
                
                if (stack.size() >= 3) {
                    char first = stack.pop();
                    if (first != '0') {
                        stack.push(first);
                        continue;
                    }
                    
                    char second = stack.pop();
                    if (second != '1') {
                        stack.push(second);
                        stack.push(first);
                        continue;
                    }
                    
                    char third = stack.pop();
                    if (third != '1') {
                        stack.push(third);
                        stack.push(second);
                        stack.push(first);
                        continue;
                    }
                    ++count;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            int idx = -1, size = stack.size() - 1;
            while (!stack.isEmpty()) {
                char value = stack.pop();
                sb.insert(0, value);
                if (idx == -1 && value == '0') {
                    idx = size;
                }
                --size;
            }
            
            int offset = idx == -1 ? 0 : ++idx;
            while (count-- > 0) {
                sb.insert(offset, "110");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}

// 111111110110