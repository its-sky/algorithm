package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CandleBag {
	static Long[] candy;
	static Integer N;
	static Long M;
	static long res;
	static long tmp, mid;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.valueOf(st.nextToken());
			M = Long.valueOf(st.nextToken());
			res = Long.MIN_VALUE;
			long end = Long.MIN_VALUE;

			candy = new Long[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				candy[i] = Long.valueOf(st.nextToken());
				end = Math.max(end, candy[i]);
			}

			binary_search(1L, end);
			if (res == Integer.MIN_VALUE)
				res = 0;
			sb.append(res).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static void binary_search(long l, long r) {
		while (l <= r) {
			mid = l + (r - l)/2;

			tmp = 0;
			for (int i = 0; i < N; ++i) {
				tmp += candy[i]/mid;
			}

			if (tmp >= M) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		res = r;
	}
}
