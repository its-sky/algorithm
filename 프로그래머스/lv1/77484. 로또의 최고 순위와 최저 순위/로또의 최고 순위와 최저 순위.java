import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zero = 0;
        List<Integer> list = new ArrayList<>();
        for (int lotto : lottos) {
            if (lotto == 0)
                ++zero;
            else
                list.add(lotto);
        }
        for (int num : win_nums) {
            if (list.contains(num))
                ++count;
        }
        int[] answer = new int[2];
        answer[0] = 7-count-zero;
        answer[1] = 7-count;
        if (answer[0] == 7)
            answer[0] = 6;
        if (answer[1] == 7)
            answer[1] = 6;
        
        return answer;
    }
}