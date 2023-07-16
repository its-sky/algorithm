import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek().equals(s.substring(i, i+1))) {
                stack.pop();
            } else {
                stack.push(s.substring(i, i+1));
            }
        }
        
        if (stack.size() > 0)
            return 0;
        return 1;
    }
}