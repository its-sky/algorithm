class Solution {
    
    int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                land[i][j] = land[i][j] + max_before(i-1, j, land);
            }
        }
        
        for (int i = 0; i < 4; i++) {
            if (land[land.length - 1][i] > answer) answer = land[land.length - 1][i];
        }
        
        return answer;
    }
    
    static int max_before(int idx, int line, int[][] land) {
        int value = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            if (i == line)
                continue;
            if (value < land[idx][i]) value = land[idx][i];
        }
        return value;
    }
}

// dfs로 하는 방법?
// 일단 O(N) 방식으로 해야함

// dp 문제인가보다

// 해당 라인 전행 + 해당 라인 값 < 해당 라인 전행의 다른 라인 최대값 + 해당 라인 값 이면 

// 124  5
// 568 12  // 4+12 > 5 + 8
// 432  1