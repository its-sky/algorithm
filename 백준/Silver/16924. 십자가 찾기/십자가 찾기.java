import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;
    static List<List<Integer>> points;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        visited = new boolean[N][M];
        points = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*') {
                    visitCross(i, j);
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*' && !visited[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(points.size());
        for (List<Integer> point : points) {
            System.out.println((point.get(0)+1) + " " + (point.get(1)+1) + " " + point.get(2));
        }
        br.close();
    }
    
    private static void visitCross(int x, int y) {
        int depth = 0;
        while (true) {
            ++depth;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i] * depth;
                int ny = y + dy[i] * depth;
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '.'){
                    if (depth - 1 > 0) {
                        visited[x][y] = true;
                        points.add(new ArrayList<>(Arrays.asList(x, y, depth - 1)));
                    }
                    return;
                }                
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i] * depth;
                int ny = y + dy[i] * depth;
                visited[nx][ny] = true;
            }
        }
    }
}