package tree;

import java.util.Scanner;

public class Ancestor {
	static int[][] tree;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; ++test_case) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			tree = new int[V+1][2];
			res = 0;
			String[] tmp = sc.nextLine().split(" ");
			for (int i = 0; i < tmp.length / 2; i++) {
				int parent = Integer.parseInt(tmp[i]);
				int child = Integer.parseInt(tmp[i+1]);
				tree[parent][child] = 1;
				tree[child][parent] = 1;
			}
		}
	}

	// 부모가 누구인지 찾는 메소드
//	int[] findAncestor(int idx) {
//
//	}

	// 해당 idx에서부터 트리 크기가 몇인지 구하는 메소드
}
