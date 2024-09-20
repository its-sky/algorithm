import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static int col = 3, row = 3;
    static int[][] map = new int[100][100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        
        int result = 0;
        while (true) {
            if (result == 101) {
                result = -1;
                break;
            }
            
            if (map[r-1][c-1] == k) {
                break;
            }
            process();
            ++result;
        }
        System.out.println(result);
    }
    
    private static void process() {
        int currRow = 0;
        int currCol = 0;
        if (row >= col) {
            for (int i = 0; i < row; i++) {
                Map<Integer, Integer> table = new HashMap<>();
                List<Combi> tmp = new LinkedList<>();
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == 0) continue;
                    table.put(map[i][j], table.getOrDefault(map[i][j], 0) + 1);
                }
                
                for (Integer key : table.keySet()) {
                    tmp.add(new Combi(key, table.get(key)));
                }
                
                Collections.sort(tmp);
                clearRow(i);
                
                // 결과 삽입
                int count = 0;
                for (Combi com : tmp) {
                    if (count == 50) break;
                    
                    map[i][2*count] = com.num;
                    map[i][2*count + 1] = com.count;
                    
                    ++count;
                }
                currCol = Math.max(currCol, Math.min(100, tmp.size() * 2));
            }
            col = Math.max(col, currCol);
        } else {
            for (int i = 0; i < col; i++) {
                Map<Integer, Integer> table = new HashMap<>();
                List<Combi> tmp = new LinkedList<>();
                for (int j = 0; j < row; j++) {
                    if (map[j][i] == 0) continue;
                    table.put(map[j][i], table.getOrDefault(map[j][i], 0) + 1);
                }
                
                for (Integer key : table.keySet()) {
                    tmp.add(new Combi(key, table.get(key)));
                }
                
                Collections.sort(tmp);
                clearCol(i);
                
                int count = 0;
                for (Combi com : tmp) {
                    if (count == 50) break;
                    
                    map[2*count][i] = com.num;
                    map[2*count + 1][i] = com.count;
                    
                    ++count;
                }
                currRow = Math.max(currRow, Math.min(100, tmp.size() * 2));
            }
            row = Math.max(row, currRow);
        }
    
    }
    
    private static void printMap() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private static void clearRow(int rowNum) {
        for (int i = 0; i < col; i++) {
            map[rowNum][i] = 0;
        }
    }
    
    private static void clearCol(int colNum) {
        for (int i = 0; i < row; i++) {
            map[i][colNum] = 0;
        }
    }
    
    static class Combi implements Comparable<Combi> {
        int num, count;
        
        public Combi(int num, int count) {
            this.num = num;
            this.count = count;
        }
        
        @Override
        public int compareTo(Combi o) {
            if (this.count == o.count) {
                return this.num - o.num;
            }
            return this.count - o.count;
        }
    }
}