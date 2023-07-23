package tree;

import org.w3c.dom.Node;

import java.util.Scanner;

public class InOrder {
	static String[] tree;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; ++test_case) {
			int N = sc.nextInt();
			sc.nextLine();
			tree = new String[N+1];
			for (int i = 0; i < N; i++) {
				String[] tmp = sc.nextLine().split(" ");
				tree[Integer.parseInt(tmp[0])] = tmp[1];
			}

			System.out.print("#" + test_case + " ");
			inOrder(1);
			System.out.println();
		}
	}

	public static void inOrder(int idx) {
		if (tree[idx*2] != null)
			inOrder(idx*2);
		System.out.print(tree[idx]);
		if (tree[idx*2+1] != null)
			inOrder(idx*2+1);
	}
}
