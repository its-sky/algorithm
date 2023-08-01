package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Candle {
	static long N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			N = Long.parseLong(br.readLine());
			long res = binary_search(0, (1L<<31) - 1);
			sb.append(res).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static long binary_search(long l, long r) {
		while (l <= r) {
			long mid = l + (r - l)/2;
			long value = cal(mid);
			if (value == N)
				return mid;
			else if (value < N)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return -1;
	}

	private static long cal(long n) {
		return n*(n+1)/2;
	}
}
