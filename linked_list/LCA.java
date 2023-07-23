package linked_list;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LCA {
	public static class Node {
		int data;
		int parentIdx, leftIdx, rightIdx;

		Node (int data) {
			this.data = data;
			this.parentIdx = 0;
			this.leftIdx = 0;
			this.rightIdx = 0;
		}
	}
	static int size;
	static Node[] nodes;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			nodes = new Node[V + 1];
			visited = new boolean[V + 1];
			for (int i = 1; i <= V; ++i) {
				nodes[i] = new Node(i);
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; ++i) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());

				if (nodes[parent].leftIdx == 0) nodes[parent].leftIdx = child;
				else nodes[parent].rightIdx = child;
				nodes[child].parentIdx = parent;
			}

			int commonParent = 1;
			while (true) {
				if (A != 1) {
					int parent = nodes[A].parentIdx;
					if (visited[parent]) {
						commonParent = parent;
						break;
					}
					visited[parent] = true;
					A = parent;
				}
				if (B != 1) {
					int parent = nodes[B].parentIdx;
					if (visited[parent]) {
						commonParent = parent;
						break;
					}
					visited[parent] = true;
					B = parent;
				}
			}
			size = 0;
			get(nodes[commonParent]);
			sb.append("#").append(t).append(" ").append(commonParent).append(" ").append(size).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void get(Node node) {
		++size;
		if (node.leftIdx != 0) get(nodes[node.leftIdx]);
		if (node.rightIdx != 0) get(nodes[node.rightIdx]);
	}
}
