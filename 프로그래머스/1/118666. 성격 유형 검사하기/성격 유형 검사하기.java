import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] scores = new int[4];
        String[] criteria = new String[]{"RT", "CF", "JM", "AN"};
        Arrays.fill(scores, 0);
        
        int apply = 0;
        for (int i = 0; i < survey.length; i++) {
            apply = choices[i] - 4;
            if (survey[i].equals("RT") || survey[i].equals("TR")) {
                if (survey[i].equals("TR")) apply *= -1;
                scores[0] += apply;
            } else if (survey[i].equals("CF") || survey[i].equals("FC")) {
                if (survey[i].equals("FC")) apply *= -1;
                scores[1] += apply;
            } else if (survey[i].equals("JM") || survey[i].equals("MJ")) {
                if (survey[i].equals("MJ")) apply *= -1;
                scores[2] += apply;
            } else if (survey[i].equals("AN") || survey[i].equals("NA")) {
                if (survey[i].equals("NA")) apply *= -1;
                scores[3] += apply;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (scores[i] > 0) sb.append(criteria[i].substring(1, 2));
            else sb.append(criteria[i].substring(0, 1));
        }
        
        return sb.toString();
    }
}