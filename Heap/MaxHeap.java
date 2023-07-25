package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MaxHeap {
	static PriorityQueue<Integer> pq;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine());
			sb = new StringBuilder();
			pq = new PriorityQueue<>(Comparator.reverseOrder());
			sb.append("#").append(t);
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				if (st.countTokens() == 2) {
					st.nextToken();
					int value = Integer.parseInt(st.nextToken());

					pq.offer(value);
				} else {
					Integer poll = pq.poll();
					if (poll == null) {
						sb.append(" ").append(-1);
					} else {
						sb.append(" ").append(poll);
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
}
