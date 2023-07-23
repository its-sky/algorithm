package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Island {
	static int N;
	static double E;
	static double minCost;
	static List<int[]> map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			map = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N];

			 String[] x_list = br.readLine().split(" ");
			 String[] y_list = br.readLine().split(" ");

			 for (int i = 0; i < N; ++i) {
				 int x = Integer.parseInt(x_list[i]);
				 int y = Integer.parseInt(y_list[i]);
				 map.add(new int[]{x, y});
			 }

			 E = Double.parseDouble(br.readLine());
			 minCost = Double.MAX_VALUE;

			 int[] start = map.get(0);
			 visited[0] = true;
			 dfs(start[0], start[1], 1, 0);

			 sb.append("#").append(t).append(" ").append(Math.round(minCost));
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int x, int y, int depth, double cost) {

		if (depth == N) {
			if (cost < minCost) {
				minCost = cost;
			}
			return;
		}

		for (int i = 0; i < N; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				int[] now = map.get(i);
				dfs(now[0], now[1], depth + 1, cost + getCost(x, y, now[0], now[1]));
				visited[i] = false;
			}
		}
	}

	private static double getCost(double x1, double y1, double x2, double y2) {
		return ((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1))*E;
	}
}
