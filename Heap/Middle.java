package Heap;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Middle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		final int MOD = 20_171_109;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());

			PriorityQueue<Integer> leftPq = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> rightPq = new PriorityQueue<>();
			leftPq.offer(A);

			int result = 0;
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

				if (X < leftPq.peek() && Y < leftPq.peek()) {
					leftPq.add(X);
					leftPq.add(Y);
					rightPq.add(leftPq.poll());
				} else if (X > leftPq.peek() && Y > leftPq.peek()) {
					rightPq.add(X);
					rightPq.add(Y);
					leftPq.add(rightPq.poll());
				} else {
					if (X < Y) {
						leftPq.add(X);
						rightPq.add(Y);
					} else {
						leftPq.add(Y);
						rightPq.add(X);
					}
				}

				result = (result + leftPq.peek()) % MOD;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
