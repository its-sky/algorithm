import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static List<List<Integer>> favorite = new ArrayList<>();
    static List<Integer> order = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        for (int i = 0; i < N*N + 1; i++) {
            favorite.add(new ArrayList<>());
        }
        
        for (int i = 0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int student = Integer.parseInt(st.nextToken());
            order.add(student);
            for (int j = 0; j < 4; j++) {
                favorite.get(student).add(Integer.parseInt(st.nextToken()));
            }
        }
        br.close();
        
        for (int student : order) {
            makePosition(student);
        }
        
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += countLikes(i, j);
            }
        }
        System.out.println(result);
    }
    
    private static int countLikes(int x, int y) {
        int result = 0;
        List<Integer> adj = favorite.get(map[x][y]);
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (isOutlier(nx, ny)) continue;
            
            if (adj.contains(map[nx][ny])) ++result;
        }
        
        if (result == 0) return 0;
        else if (result == 1) return 1;
        else if (result == 2) return 10;
        else if (result == 3) return 100;
        return 1000;
    }
    
    private static void makePosition(int student) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    int fav = countFavorite(student, i, j);
                    int empty = countEmpty(i, j);
                    points.add(new Point(i, j, fav, empty));
                }
            }
        }
        
        Collections.sort(points);
        Point result = points.get(0);
        map[result.x][result.y] = student;
    }
    
    private static int countFavorite(int student, int x, int y) {
        int result = 0;
        List<Integer> like = favorite.get(student);
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (isOutlier(nx, ny)) continue;
            
            if (like.contains(map[nx][ny])) ++result;
        }
        return result;
    }
    
    private static int countEmpty(int x, int y) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (isOutlier(nx, ny)) continue;
            
            if (map[nx][ny] == 0) ++result;
        }
        return result;
    }
    
    private static boolean isOutlier(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }
    
    static class Point implements Comparable<Point> {
        int x, y, adj, empty;
        
        public Point(int x, int y, int adj, int empty) {
            this.x = x;
            this.y = y;
            this.adj = adj;
            this.empty = empty;
        }
        
        @Override
        public int compareTo(Point o) {
            if (this.adj == o.adj) {
                if (this.empty == o.empty) {
                    if (this.x == o.x) {
                        return this.y - o.y;
                    }
                    return this.x - o.x;
                }
                return o.empty - this.empty;
            }
            return o.adj - this.adj;
        }
    }
}