import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for (String[] pic : photo) {
            int res = 0;
            for (String n : pic) {
                res += map.getOrDefault(n, 0);
            }
            list.add(res);
        }
        
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}