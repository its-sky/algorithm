package GraphSearch;

import java.io.*;
import java.util.*;

public class LCA {
	static int N;
	static long result;

	static int[] depths;
	static int[][] parents;
	static ArrayList<ArrayList<Integer>> adjustList;
	static List<Integer> searchList;

	static final int MAX_DEPTH = 18;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		searchList = new ArrayList<>();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			sb.append("#").append(test_case).append(' ');

			N = Integer.parseInt(br.readLine());
			init();

			st = new StringTokenizer(br.readLine());
			for (int i = 2; i <= N; ++i) {
				int nodeNum = Integer.parseInt(st.nextToken());
				adjustList.get(i).add(nodeNum);
				adjustList.get(nodeNum).add(i);
			}

			BFS(1);
			setParent();

			int size = searchList.size();
			for (int i = 0; i < size - 1; ++i) {
				int node1 = searchList.get(i);
				int node2 = searchList.get(i + 1);
				int sameParent = LCA(node1, node2);

				result += depths[node1] - depths[sameParent];
				result += depths[node2] - depths[sameParent];
			}

			sb.append(result).append('\n');
		}

		bw.write(sb.toString());
		bw.close();
	}

	static void BFS(int vertex) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		q.offer(vertex);

		while (!q.isEmpty()) {
			int pollNode = q.poll();
			visited[pollNode] = true;
			searchList.add(pollNode);

			int size = adjustList.get(pollNode).size();
			for (int i = 0; i < size; ++i) {
				int child = adjustList.get(pollNode).get(i);

				if (visited[child]) continue;

				parents[child][0] = pollNode;
				depths[child] = depths[pollNode] + 1;
				q.offer(child);
			}
		}
	}

	static int LCA(int node1, int node2) {
		if (depths[node1] < depths[node2]) {
			int tmp = node1;
			node1 = node2;
			node2 = tmp;
		}

		for (int i = MAX_DEPTH; i >= 0; --i) {
			long diff = depths[node1] - depths[node2];
			if (diff >= (1L << i))
				node1 = parents[node1][i];
		}

		if (node1 == node2)
			return node1;

		for (int i = MAX_DEPTH; i >= 0; --i) {
			if (parents[node1][i] != parents[node2][i]) {
				node1 = parents[node1][i];
				node2 = parents[node2][i];
			}
		}

		return parents[node1][0];
	}

	static void setParent() {
		for (int i = 1; i <= MAX_DEPTH; ++i) {
			for (int j = 1; j <= N; ++j) {
				int halfParent = parents[j][i - 1];
				parents[j][i] = parents[halfParent][i - 1];
			}
		}
	}

	static void init() {
		parents = new int[N + 1][MAX_DEPTH + 1];
		depths = new int[N + 1];
		result = 0;
		adjustList = new ArrayList<>();
		for (int i = 0; i <= N; ++i) {
			adjustList.add(new ArrayList<>());
		}
		searchList.clear();
	}
}
