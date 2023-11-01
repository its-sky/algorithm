import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Obstacle {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);

        List<Integer> result = new ArrayList<>();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] nums = input[i + 1].split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(nums[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int count = bfs(i, j);
                    result.add(count);
                }
            }
        }

        System.out.print(result.size());
        for (Integer count : result) {
            System.out.print(" " + count);
        }
    }

    private static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        int count = 1;

        while (!q.isEmpty()) {
            Point curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + curr.x;
                int ny = dy[i] + curr.y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    ++count;
                }
            }
        }

        return count;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
