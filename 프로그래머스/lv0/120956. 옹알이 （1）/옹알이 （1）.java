class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] tmp = { "aya", "ye", "woo","ma" };
        
        for (String babble : babbling) {
            int len = babble.length();
            for (int i = 0; i < tmp.length; i++) {
                if (babble.contains(tmp[i])) {
                    if (len - tmp[i].length() >= 0) {
                        len -= tmp[i].length();
                    }
                }
            }
            if (len == 0)
                ++answer;
        }
        
        return answer;
    }
}