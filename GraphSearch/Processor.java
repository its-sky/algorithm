package GraphSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Processor {
	static class Core {
		int x,y;

		public Core(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int N, minWireLength, maxCore;
	static List<Core> coreList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; ++test_case) {
			sc.nextLine();
			N = sc.nextInt();
			sc.nextLine();
			map = new int[N][N];
			coreList = new ArrayList<>();
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					int tmp = sc.nextInt();
					if (tmp == 1) {
						map[i][j] = 1;

						if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
							continue;
						coreList.add(new Core(i, j));
					}
				}
			}

			minWireLength = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;

			connect(0, 0, 0);

			sb.append("#"+test_case + " " + minWireLength + "\n");
		}
		System.out.println(sb.toString());
	}

	static void connect(int idx, int coreCnt, int wireCnt) {
		if (idx == coreList.size()) {
			if (maxCore < coreCnt) {
				maxCore = coreCnt;
				minWireLength = wireCnt;
			} else if (maxCore == coreCnt) {
				minWireLength = Math.min(minWireLength, wireCnt);
			}
			return;
		}

		int x = coreList.get(idx).x;
		int y = coreList.get(idx).y;

		for (int dir=0; dir<4; ++dir) {
			int count=0, nx=x, ny=y;

			while (true) {
				nx += dx[dir];
				ny += dy[dir];

				if (ny < 0 || ny >= N || nx < 0 || nx >= N)
					break;

				if (map[ny][nx] == 1) {
					count = 0;
					break;
				}

				++count;
			}

			int fill_x = x;
			int fill_y = y;

			for (int i = 0; i < count; ++i) {
				fill_x += dx[dir];
				fill_y += dy[dir];
				map[fill_y][fill_x] = 1;
			}

			if (count == 0)
				connect(idx+1, coreCnt, wireCnt);
			else {
				connect(idx+1, coreCnt+1, wireCnt + count);

				fill_x = x;
				fill_y = y;

				for (int i = 0; i < count; ++i) {
					fill_x += dx[dir];
					fill_y += dy[dir];
					map[fill_y][fill_x] = 0;
				}
			}
		}
	}
}
