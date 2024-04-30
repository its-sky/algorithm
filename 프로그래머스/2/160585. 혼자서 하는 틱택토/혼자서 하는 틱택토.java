class Solution {
    public int solution(String[] board) {
        char[][] map = new char[3][3];
        
        for (int i = 0; i < 3; i++) {
            map[i] = board[i].toCharArray();
        }
        
        boolean[] success = check(map);
        
        if (success[0] && success[1]) {
            return 0;
        }
        
        int[] res = count(map);
        
        if (res[0] == res[1]) {
            if (success[0]) return 0;
            return 1;
        }
        else if (res[0] == res[1] + 1) {
            if (success[1]) return 0;
            return 1;
        }
        else return 0;
    }
    
    private boolean[] check(char[][] map) {
        boolean[] res = new boolean[2];
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == map[i][1] && map[i][0] == map[i][2]) {
                if (map[i][0] == 'O') res[0] = true;
                else if (map[i][0] == 'X') res[1] = true;
            }
            if (map[0][i] == map[1][i] && map[0][i] == map[2][i]) {
                if (map[0][i] == 'O') res[0] = true;
                else if (map[0][i] == 'X') res[1] = true;
            }
        }
        if (map[0][0] == map[1][1] && map[0][0] == map[2][2]) {
            if (map[0][0] == 'O') res[0] = true;
            else if (map[0][0] == 'X') res[1] = true;
        }
        if (map[0][2] == map[1][1] && map[0][2] == map[2][0]) {
            if (map[0][2] == 'O') res[0] = true;
            else if (map[0][2] == 'X') res[1] = true;
        } 
        return res;
    }
    
    private int[] count (char[][] map) {
        int[] res = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 'O') ++res[0];
                else if (map[i][j] == 'X') ++res[1];
            }
        }
        return res;
    }
}

// 1. 선공 O, 후공 X
// 둘다 3개로 한줄 만들기에 성공할 수는 없음
// O는 없는데 X만 있을수는 없음