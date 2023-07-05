import java.util.*;

class Solution {
    public int solution(String A, String B) {
        if (A.length() != B.length())
            return -1;
        
        for (int i = 0; i < B.length(); i++) {
            if (B.charAt(i) == A.charAt(0)) {
                int mode = 0;
                for (int j = i; j < i + A.length(); j++) {
                    if (A.charAt((j - i) % A.length()) != B.charAt(j % B.length())) {
                        mode = 1;
                        break;
                    }
                }
                if (mode == 0)
                    return i;
            }
        }
        
        return -1;
    }
}