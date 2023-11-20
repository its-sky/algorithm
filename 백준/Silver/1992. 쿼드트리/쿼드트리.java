import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String inputs = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = inputs.charAt(j) - '0';
            }
        }
        br.close();
        
        QuadTree(0, 0, n);
        
        System.out.println(sb.toString());
    }
    
    private static void QuadTree(int x, int y, int size) {
        if (isSame(x, y, size)) {
            sb.append(map[x][y]);
            return;
        }
        
        int newSize = size / 2;
        
        sb.append("(");
        
        QuadTree(x, y, newSize);
        QuadTree(x, y + newSize, newSize);
        QuadTree(x + newSize, y, newSize);
        QuadTree(x + newSize, y + newSize, newSize);
        
        sb.append(")");
    }
    
    private static boolean isSame(int x, int y, int size) {
        int target = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (target != map[i][j]) return false;
            }
        }
        
        return true;
    }
}