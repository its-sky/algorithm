package Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Robot {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}; // U, R, D, L
    static int n, m;
    static int dr = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sizes = br.readLine().split(" ");

        n = Integer.parseInt(sizes[0]);
        m = Integer.parseInt(sizes[1]);

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] split = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = split[j];
            }
        }

        // 일단 시작 포인트를 찾아야함. 시작 포인트는 옆에 #이 한개밖에 없는 곳임.
        Point start = findStart();
        char[] dirs = {'^', '>', 'v', '<'};
        char start_dir = dirs[dr];
//        System.out.println(dr + ", " + start.x + ", " + start.y);
        String route = bfs(start);

        System.out.println((start.x+1) + " " + (start.y+1));
        System.out.println(start_dir);
        System.out.println(route);
    }

    private static Point findStart() {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                    if (map[nx][ny] == '#') {
                        dr = i;
                        ++cnt;
                    }
                }

                if (cnt == 1 && map[x][y] == '#') return new Point(x, y);
            }
        }
        return null;
    }

    private static String bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        StringBuilder route = new StringBuilder();

        while (!q.isEmpty()) {
            Point curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (!visited[nx][ny] && map[nx][ny] == '#') {
                    if ((i - dr) == 1 || (i - dr) == -3) {
                        route.append("R"); // 오른쪽으로 돌리기
                        dr = i;
                    }
                    else if ((i - dr) == -1 || (i - dr) == 3) {
                        route.append("L"); // 왼쪽으로 돌리기
                        dr = i;
                    }

                    int nnx = curr.x;
                    int nny = curr.y;
                    for (int step = 0; step < 2; step++) {
                        nnx += dx[dr];
                        nny += dy[dr];
                        visited[nnx][nny] = true;
                    }
                    route.append("A");
                    q.add(new Point(nnx, nny));
                }
            }
        }

        return route.toString();
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
