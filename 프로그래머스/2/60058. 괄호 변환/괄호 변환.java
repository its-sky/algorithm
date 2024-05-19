import java.util.*;

class Solution {
    public String solution(String p) {
        return process(p);
    }
    
    private String process(String p) {
        if (p.equals("")) return p;
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < p.length(); i++) {
            if (stack.size() == 0 || (stack.size() > 0 && stack.peek() == p.charAt(i))) stack.push(p.charAt(i));
            else if (stack.peek() != p.charAt(i)) {
                stack.pop();
                if (stack.size() == 0) {
                    // 여기가 균형잡힘 괄호 문자열 u
                    if (isCorrect(p.substring(0, i + 1))) {
                        return p.substring(0, i + 1) + process(p.substring(i + 1, p.length()));
                    } else {
                        return "(" + process(p.substring(i + 1, p.length())) + ")" + flip(p.substring(1, i));
                    }
                }
            }
        }
        return p;
    }
    
    private boolean isCorrect(String p) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') stack.push(p.charAt(i));
            else if (stack.size() > 0 && p.charAt(i) == ')') {
                stack.pop();
            }
        }
        if (stack.size() == 0) return true;
        return false;
    }
    
    private String flip(String p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') sb.append(")");
            else if (p.charAt(i) == ')') sb.append("(");
        }
        return sb.toString();
    }
    
}