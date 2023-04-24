class Solution {
    boolean solution(String s) {
        int openCnt = 0;
        int closeCnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') 
                ++openCnt;
            else if (s.charAt(i) == ')')
                ++closeCnt;
            
            if (openCnt < closeCnt)
                return false;
        }
        if (openCnt == closeCnt)
            return true;
        return false;
    }
}