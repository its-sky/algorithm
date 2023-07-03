import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int target = n;

        if (target % 2 != 0) {
            ans += 1;
            target -= 1;
        }
        
        while (target > 0) {
            if (target % 2 == 0) {
                target = target / 2;
            } else {
                ans += 1;
                target = target - 1;
            }
        }

        return ans;
    }
}