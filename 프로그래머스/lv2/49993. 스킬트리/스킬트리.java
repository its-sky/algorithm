import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String tree : skill_trees) {
            String tempSkill = tree;
            
            for (int i = 0; i < tree.length(); i++) {
                String s = tree.substring(i, i+1);
                if (!skill.contains(s)) {
                    tempSkill = tempSkill.replace(s, "");
                }
            }
            
            if (skill.indexOf(tempSkill) == 0)
                ++answer;
        }
        
        return answer;
    }
}
// 순서대로 체크하는데, 체크하고 남은 것들이 원래 원소에 들어가있는지 체크해야함.

// 전에가 -1이거나 작으면, 하지만 작을때 -1이고 마지막이면 면제