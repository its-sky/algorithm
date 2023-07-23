package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Calculation {
	static int N;
	static Object[] tree;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; ++t) {
			N = Integer.parseInt(br.readLine());
			tree = new Object[N + 1];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int idx = Integer.parseInt(st.nextToken());
				char tmp = st.nextToken().charAt(0);
				tree[idx] = tmp;

//				if (st.countTokens() == 1) {
//					int value = Integer.parseInt(st.nextToken());
//					tree[idx] = value;
//				} else {
//					char op = st.nextToken().charAt(0);
//					tree[idx] = op;
//				}
			}
		}
	}

//	public static int inOrder_calculate(int now, int idx) {
//		if (idx*2 <= N) inOrder_calculate(now, idx*2);
//		if ('0' <= tree[idx] && tree[idx] <= '9')
//		if (tree[idx].equals("+")) {
//			now = now + inOrder_calculate(now,)
//		}
//	}
}
