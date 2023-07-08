class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        int[][] map = new int[n][];
        
        for (int i = 0; i < n; i++) {
            map[i] = new int[i + 1];
        }
        
        int y = 0;
        int x = 0;
        int cnt = n;
        int value = 1;
        int mode = -1;
        
        for (int i = 0; i < n; i++) {
            cnt -= 1;
            mode = (mode + 1) % 3;
            if (mode == 0) {
                for (int j = 0; j < cnt; j++) {
                    map[y++][x] = value++;
                }
                map[y][x++] = value++;
            } else if (mode == 1) {
                for (int j = 0; j < cnt; j++) {
                    map[y][x++] = value++;
                }
                map[y--][x--] = value++;
            } else if (mode == 2) {
                for (int j = 0; j < cnt; j++) {
                    map[y--][x--] = value++;
                }
                map[y++][x] = value++;
            }
        }
        
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[idx++] = map[i][j];
            }
        }
        
        return answer;
    }
}