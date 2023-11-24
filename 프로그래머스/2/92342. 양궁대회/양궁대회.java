import java.util.*;

class Solution {
    static List<Integer[]> res;
    static int res_count = 0;
    public int[] solution(int n, int[] info) {
        Integer[] curr = new Integer[11];
        Arrays.fill(curr, 0);
        res = new ArrayList<>();
        dfs(n, 0, info, curr);
        
        if (res_count == 0) return new int[]{-1};
        
        Collections.sort(res, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] arr1, Integer[] arr2) {
                for (int i = 10; i >= 0; i--) {
                    if (arr1[i] - arr2[i] > 0) return -1;
                    else if (arr1[i] - arr2[i] < 0) return 1;
                }
                return 0;
            }
        });
    
        Integer[] result = res.get(0);
        int[] arr = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            arr[i] = result[i].intValue();
        }
        
        return arr;
    }
    
    private static void dfs(int spare, int depth, int[] info, Integer[] curr) {
        if (spare == 0 || depth == 11) {
            if (spare != 0 && depth == 11) curr[depth - 1] = spare;
            int tmp = 0;
            for (int i = 0; i < curr.length; i++) {
                if (curr[i] - info[i] > 0) tmp += 10 - i;
                else if (info[i] != 0) tmp -= 10 - i;
            }
            if (tmp > res_count) {
                res.clear();
                res.add(curr);
                res_count = tmp;
            } else if (tmp == res_count) {
                res.add(curr);
            }
            return;
        }
        
        if (spare >= info[depth] + 1) {
            Integer[] new_curr = curr.clone();
            new_curr[depth] = info[depth] + 1;
            dfs(spare - (info[depth]+1), depth+1, info, new_curr);
        }
        dfs(spare, depth+1, info, curr);
    }
}