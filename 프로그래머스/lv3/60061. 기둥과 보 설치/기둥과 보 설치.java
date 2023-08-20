import java.util.*;

class Solution {
    boolean[][] pillar;
    boolean[][] bar;
    
    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n+1][n+1];
        bar = new boolean[n+1][n+1];
        
        int count = 0;
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2];
            int action = build_frame[i][3];
            
            if (type == 0) { // 기둥
                if (action == 1) { // 설치
                    if (checkPillar(x, y)) {
                        pillar[x][y] = true;
                        ++count;
                    }
                } else { // 삭제
                    pillar[x][y] = false;
                    if (canDelete(n) == false) pillar[x][y] = true;
                    else --count;
                }
            } else { // 보
                if (action == 1) { // 설치
                    if (checkBar(x, y)) {
                        bar[x][y] = true;
                        ++count;
                    }
                } else { // 삭제
                    bar[x][y] = false;
                    if (canDelete(n) == false) bar[x][y] = true;
                    else --count;
                }
            }
        }
        
        int[][] result = new int[count][3];
        int idx = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillar[i][j]) {
                    result[idx][0] = i;
                    result[idx][1] = j;
                    result[idx++][2] = 0;
                }
                if (bar[i][j]) {
                    result[idx][0] = i;
                    result[idx][1] = j;
                    result[idx++][2] = 1;
                }
            }
        }
            
        return result;
    }
    
    private boolean canDelete(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillar[i][j] && checkPillar(i, j) == false) return false;
                if (bar[i][j] && checkBar(i, j) == false) return false;
            }
        }
        return true;
    }
    
    private boolean checkPillar(int x, int y) {
        if (y == 0) return true;
        else if (y > 0 && pillar[x][y - 1]) return true; // 아래 기둥이 있는 경우
        else if (x > 0 && bar[x - 1][y] || bar[x][y]) return true;
        return false;
    }
    
    private boolean checkBar(int x, int y) {
        if (y > 0 && pillar[x][y - 1] || pillar[x + 1][y - 1]) return true; // 한쪽 끝에 기둥이 있는 경우
        else if (x > 0 && bar[x - 1][y] && bar[x + 1][y]) return true; // 양쪽 끝이 보와 연결되어 있는 경우
        return false;
    }
}

// 기둥을 삭제할 때 위와 아래에 연결된 보가 있는지 확인하고 이 보가 유지될 수 있는지를 확인해야함
// 그리고 기둥 삭제할 때 위에 기둥이 또 있는지를 확인해야 할 거 같음.
// 보를 삭제할 때 좌우에 보가 있는지 확인하고 보가 있으면 아래에 지탱하는 기둥이 있는지 확인해서 없으면 무시.
// 그리고 핵심은 좌표를 2배해서 체크해야함. 그래야 겹치는 부분을 해소할 수 있음.

// -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
// -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
// -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
// -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
// -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
// -1 -1 
// -1        0  1  1  1  1  1  1  0
// -1        0                    0
// -1  1  1  0                    0
// -1  0                          0

// 기둥 아래에 보가 달려있다면 해당 보 오른쪽 끝에서 왼쪽으로 두칸 가서 기둥이 있는지 체크하거나 오른쪽 왼쪽에 보가 연결되어 있는지 체크
// 기둥 위 오른쪽에 보가 달려있다면 