class Solution {
    static int[][] map;
    static int[] result;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int tmp = 1;
        map = new int[rows][columns];
        result = new int[queries.length];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                map[i][j] = tmp++;
            }
        }
        tmp = 0;
        for (int[] query : queries) {
            result[tmp++] = rotate(query);
        }
        return result;
    }
    
    private int rotate(int[] query) {
        int x1 = query[1]-1, x2 = query[3]-1;
        int y1 = query[0]-1, y2 = query[2]-1;

        int tmp = map[y1][x2];
        int min = tmp;
        for (int i=x2; i>x1; i--) {
            map[y1][i] = map[y1][i-1];
            if (map[y1][i] < min)
                min = map[y1][i];
        }
        for (int i=y1; i<y2; i++) {
            map[i][x1] = map[i+1][x1];
            if (map[i][x1] < min)
                min = map[i][x1];
        }
        for (int i=x1; i<x2; i++) {
            map[y2][i] = map[y2][i+1];
            if (map[y2][i] < min)
                min = map[y2][i];
        }
        for (int i=y2; i>y1; i--) {
            map[i][x2] = map[i-1][x2];
            if (map[i][x2] < min)
                min = map[i][x2];
        }
        map[y1+1][x2] = tmp;
        return min;
    }
}