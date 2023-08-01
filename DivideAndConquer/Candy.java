package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Candy {
	static long mod;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			long A = Integer.parseInt(st.nextToken());
			long B = Integer.parseInt(st.nextToken());
			long K = Integer.parseInt(st.nextToken());

			mod = A + B;
			long kp = cal(K);
			A = (A * kp) % mod;
			long result = Math.min(A, mod - A);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static long cal(long n) {
		if (n == 1) return 2;

		long ret = cal(n / 2);
		ret = (ret * ret) % mod;
		if ((n & 1) == 1) ret = (ret * 2) % mod;

		return ret;
	}
}
