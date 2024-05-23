import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < operations.length; i++) {
            String[] input = operations[i].split(" ");
            if (input[0].equals("I")) {
                int value = Integer.parseInt(input[1]);
                min.offer(value);
                max.offer(value);
            } else if (input[0].equals("D")) {
                if (input[1].equals("1")) {
                    if (max.size() == 0) continue;
                    int value = max.poll();
                    min.remove(value);
                } else {
                    if (min.size() == 0) continue;
                    int value = min.poll();
                    max.remove(value);
                }
            }
        }
        
        if (max.size() > 0) {
            answer[0] = max.poll();
        }
        if (min.size() > 0) {
            answer[1] = min.poll();
        }
        
        return answer;
    }
}