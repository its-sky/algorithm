class Solution {
    static int M;
    static int N;
    static int total = 0;
    static int[][] map;
    static int[][] keys;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        M = key.length;
        N = lock.length;
        int size = lock.length + key.length*2 - 2;
        map = new int[size][size];
        keys = key;
        
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                map[key.length-1+i][key.length-1+j] = lock[i][j];
                if (lock[i][j] == 0) ++total;
            }
        }
        
        for (int dr = 0; dr < 4; dr++) {
            if (check())
                return true;
            rotate();
        }
        
        return false;
    }
    
    private void rotate() {
        int n = keys.length;
        int m = keys.length;
        int[][] rotate = new int[m][n];
        
        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = keys[n-1-j][i];
            }
        }
        
        keys = rotate;
    }
    
    private boolean check() {
        int mapLen = map.length;
        for (int i = 0; i < mapLen - M+1; i++) {
            for (int j = 0; j < mapLen - M+1; j++) {
                for (int k = 0; k < M; k++) {
                    for (int l = 0; l < M; l++) {
                        map[i+k][j+l] += keys[k][l];
                    }
                }
                
                boolean flag = true;
                for (int k = M-1; k < N+M - 1; k++) {
                    for (int l = M-1; l < N+M - 1; l++) {
                        if (map[k][l] != 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                }
                
                if (flag) return true;
                
                for (int k=0; k < M; k++) {
                    for (int l=0; l < M; l++) {
                        map[i+k][j+l] -= keys[k][l];
                    }
                }
            }
        }
        
        return false;
    }
}

// 회전을 해야하는데 회전 했을 때 여기가 맞다는 생각을 어떻게 하지?
// 생각을 하는게 아니라 브루트 포스로 갈겨보는건가?


// 48cg 저장