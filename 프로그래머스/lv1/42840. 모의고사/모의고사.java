import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] arr = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        
        for (int i=0; i<arr.length; i++) {
            int cnt = 0;
            for (int j=0; j<answers.length; j++) {
                if (arr[i][j%arr[i].length] == answers[j]) cnt++;
            }
            list.add(cnt);
        }
        int m = Math.max(list.get(0), Math.max(list.get(1), list.get(2)));
        for (int i=0; i<list.size(); i++) {
            if (list.get(i) >= m) {
                count.add(i);
            }
        }
        
        int[] answer = new int[count.size()];
        for (int i=0; i<count.size(); i++) {
            answer[i] = count.get(i)+1;
        }
        
        return answer;
    }
}