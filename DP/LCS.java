package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			String[] tmp = br.readLine().split(" ");
			char[] A = tmp[0].toCharArray();
			char[] B = tmp[1].toCharArray();
			int m = A.length;
			int n = B.length;
			int dp[][] = new int[m+1][n+1];

			for (int i = 0; i <= m; ++i) {
				for (int j = 0; j <= n; ++j) {
					if (i == 0 || j == 0) {
						dp[i][j] = 0;
						continue;
					}
					if (A[i-1] == B[j-1]) {
						dp[i][j] = dp[i-1][j-1] + 1;
						continue;
					}
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			System.out.println("#" + t + " " + dp[m][n]);
		}
	}
}
