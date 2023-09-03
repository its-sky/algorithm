import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();
        
        answer[0] = 0;
        answer[1] = 0;
        
        map.put(words[0], 1);
        
        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            } else {
                if (map.containsKey(words[i])) {
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    break;
                } else {
                    map.put(words[i], 1);
                }
            }
        }

        return answer;
    }
}