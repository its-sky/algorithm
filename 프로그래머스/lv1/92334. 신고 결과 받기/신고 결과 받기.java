import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reporterInfoMap = new HashMap<>();
        HashMap<String, Integer> reportedCountInfoMap = new HashMap<>();
        
        for (String reportInfo : report) {
            String reporter = reportInfo.split(" ")[0];
            String reportee = reportInfo.split(" ")[1];
            boolean flag = false;
            
            if (reporterInfoMap.containsKey(reporter)) {
                if(reporterInfoMap.get(reporter).contains(reportee)) {
                    flag = true;
                } else {
                    reporterInfoMap.get(reporter).add(reportee);
                }
            } else {
                reporterInfoMap.put(reporter, new HashSet<String>(){{
                    add(reportee);
                }});
            }
            
            if (flag) {
                continue;
            } else if (reportedCountInfoMap.containsKey(reportee)) {
                reportedCountInfoMap.put(reportee, reportedCountInfoMap.get(reportee) + 1);
            } else {
                reportedCountInfoMap.put(reportee, 1);
            }
        }
        
        for (String reportee : reportedCountInfoMap.keySet()) {
            int reportedCount = reportedCountInfoMap.get(reportee);
            if (reportedCount >= k) {
                for (int i=0; i<id_list.length; i++) {
                    if (reporterInfoMap.get(id_list[i]) == null) {
                        answer[i] = 0;
                    } else if (reporterInfoMap.get(id_list[i]).contains(reportee)) {
                        ++answer[i];
                    }
                }
            }
        }
        
        return answer;
    }
}