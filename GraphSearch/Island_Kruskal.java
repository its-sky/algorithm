package GraphSearch;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Island_Kruskal {
	static int N, parents[];
	static double E;
	static Point[] land;
	static ArrayList<Edge> edgeList;

	static class Edge implements Comparable<Edge> {
		int from, to;
		long w;

		public Edge(int from, int to, long w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			land = new Point[N];
			parents = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				land[i] = new Point(0, 0);
				land[i].x = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				land[i].y = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());

			edgeList = new ArrayList<>();
			for (int i = 0; i < N; ++i) {
				for (int j = i + 1; j < N; ++j) {
					long distX = Math.abs(land[i].x - land[j].x);
					long distY = Math.abs(land[i].y - land[j].y);
					edgeList.add(new Edge(i, j, distX*distX + distY*distY));
				}
			}
			edgeList.sort(null);
			make();

			int cnt = 0;
			long res = 0;
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					res += edge.w;
					if (++cnt == N - 1) break;
				}
			}
			System.out.println("#" + tc + " " + Math.round(res * E));
		}
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		for (int i = 1; i < N + 1; ++i)
			parents[i] = i;
	}
}
