package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Supply {
	static class Pos implements Comparable<Pos> {
		int x;
		int y;
		int time;

		public Pos(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Pos p) {
			if (this.time > p.time)
				return 1;
			else if (this.time < p.time)
				return -1;
			return 0;
		}
	}
	static PriorityQueue<Pos> pq;
	static int N, min;
	static boolean[][] visited;
	static int[][] map, ans;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			visited = new boolean[N][N];
			pq = new PriorityQueue<>();
			for (int i = 0; i < N; ++i) {
				char[] input = br.readLine().toCharArray();
				for (int j = 0; j < input.length; ++j) {
					map[i][j] = input[j] - '0';
				}
			}

			min = Integer.MAX_VALUE;

			ans = new int[N][N];
			for (int i=0; i < N; ++i) {
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			}
			ans[0][0] = 0;

			bfs(0, 0);
			System.out.println("#" + t + " " + min);
		}
		br.close();
	}

	private static void bfs(int x, int y) {
		pq.offer(new Pos(x,y,0));
		visited[x][y] = true;

		while (!pq.isEmpty()) {
			Pos p = pq.poll();
			int a = p.x;
			int b = p.y;
			int time = p.time;

			if (a == N - 1 && b == N - 1)
				min = Math.min(min, time);

			if (min <= time)
				continue;

			for (int i = 0; i < 4; ++i) {
				int nx = a + dx[i];
				int ny = b + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				int dTime = time + map[nx][ny];
				if (!visited[nx][ny] || dTime < ans[nx][ny]) {
					visited[nx][ny] = true;
					ans[nx][ny] = dTime;
					pq.offer(new Pos(nx, ny, dTime));
				}
			}

		}
	}
}
