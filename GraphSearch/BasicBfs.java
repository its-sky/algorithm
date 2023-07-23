package GraphSearch;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BasicBfs {
	static int N;
	static int res = 0;
	static int[][] map;
	static int[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		bfs_init(sc);

		int M = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < M; ++i) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			sc.nextLine();

			bfs(x1 - 1, y1 - 1, x2 - 1, y2 - 1);

			if (visited[y2 - 1][x2 - 1] == 0)
				res -= 1;
			else
				res += visited[y2 - 1][x2 - 1];
		}
		System.out.println("#total score : " + res);
	}

	static void bfs_init(Scanner sc) {
		N = sc.nextInt();
		sc.nextLine();

		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				map[i][j] = sc.nextInt();
			}
		}
	}

	static void bfs(int x1, int y1, int x2, int y2) {
		visited = new int[N][N];
		Queue<int[]> q = new LinkedList<>();
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};

		q.add(new int[]{y1, x1});
		while (!q.isEmpty()) {
			int[] now = q.remove();
			if (now[0] == y2 && now[1] == x2)
				return;

			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (visited[ny][nx] == 0 && map[ny][nx] == 0) {
						visited[ny][nx] = visited[now[0]][now[1]] + 1;
						q.add(new int[]{ny, nx});
					}
				}
			}
		}
	}
}
