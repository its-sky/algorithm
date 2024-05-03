import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int turn = 1;
        int idx = 0;
        while (true) {
            if (idx == order.length) {
                if (stack.size() == 0) break;
                Integer top = stack.peek();
                if (top == order[idx]) {
                    stack.pop();
                    ++answer;
                    ++idx;
                } else {
                    break;
                }
            }
            
            if (turn < order[idx]) {
                stack.push(turn++);
            } else if (turn == order[idx]) {
                ++answer;
                ++turn;
                ++idx;
            } else {
                // 현재 turn보다 작으면 stack의 top에 있는 것과 비교
                // 비교해서 맞지 않으면 break;
                if (stack.size() == 0) break;
                Integer top = stack.peek();
                if (top == order[idx]) {
                    stack.pop();
                    ++answer;
                    ++idx;
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
    
    // < 1 2 3
}