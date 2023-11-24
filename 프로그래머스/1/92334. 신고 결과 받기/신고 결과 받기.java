import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reports = new HashMap<>();
        Map<String, Integer> mapping = new HashMap<>();
        int[] res = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            mapping.put(id_list[i], i);
        }
        
        for (String tmp : report) {
            String[] inputs = tmp.split(" ");
            if (reports.containsKey(inputs[1])) {
                Set<String> set = reports.get(inputs[1]);
                set.add(inputs[0]);
                reports.put(inputs[1], set);
            } else {
                Set<String> set = new HashSet<>();
                set.add(inputs[0]);
                reports.put(inputs[1], set);
            }
        }
        
        for (String reported : reports.keySet()) {
            Set<String> set = reports.get(reported);
            if (set.size() >= k) {
                for (String people : set) {
                    res[mapping.get(people)] += 1;
                }
            }
        }
        
        return res;
    }
}