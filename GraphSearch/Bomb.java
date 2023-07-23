package GraphSearch;

import java.util.Scanner;
import java.util.Stack;

public class Bomb {
	static int N, res;
	static char[][] map;
	static int[][] mCnt;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }, dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case=1; test_case<=T; ++test_case) {
			N = sc.nextInt();
			sc.nextLine();
			map = new char[N][N];
			mCnt = new int[N][N];
			res = 0;

			for (int i = 0; i < N; ++i) {
				map[i] = sc.nextLine().toCharArray();
			}

			countMine();

			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (mCnt[i][j] == 0 && map[i][j] != '*') {
						click(i, j);
						++res;
					}
				}
			}

			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (mCnt[i][j] > 0 && map[i][j] != '*') {
						++res;
					}
				}
			}

			System.out.println("#" + test_case + " " + res);
		}
	}

	static void countMine() {
		for (int x = 0; x < N; ++x) {
			for (int y = 0; y < N; ++y) {
				if (map[x][y] == '.') {
					int cnt = 0;
					for (int d = 0; d < 8; ++d) {
						int nx = x + dx[d];
						int ny = y + dy[d];

						if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != '*')
							continue;
						++cnt;
					}
					mCnt[x][y] = cnt;
				}
			}
		}
	}

	static void click(int x, int y) {
		int now = mCnt[x][y];
		mCnt[x][y] = -1;

		if (now == 0) {
			for (int d = 0; d < 8; ++d) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || mCnt[nx][ny] == -1 || map[nx][ny] == '*')
					continue;

				click(nx, ny);
			}
		}
	}
}