package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Highway {
	static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int c;

		public Edge(int s, int e, int c) {
			this.s = s;
			this.e = e;
			this.c = c;
		}


		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.c, o.c);
		}
	}

	static List<Edge> edgeList;
	static int N, M, parents[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			parents = new int[N];
			edgeList = new ArrayList<>();

			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				Edge new_edge = new Edge(s, e, c);
				edgeList.add(new_edge);
			}
			edgeList.sort(null);
			make();

			int cnt = 0;
			long res = 0;
			for (Edge edge : edgeList) {
				if (union(edge.s - 1, edge.e - 1)) {
					res += edge.c;
					if (++cnt == N - 1) break;
				}
			}
			System.out.println("#" + tc + " " + res);
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
		for (int i = 0; i < N; ++i)
			parents[i] = i;
	}
}
