package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Word {
	static String origin;
	static String pattern;
	static int[] pi;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			origin = br.readLine();
			pattern = br.readLine();

			test(t);
		}
	}

	private static void test(int testNo) {
		result = 0;
		pi = new int[pattern.length()];

		getPi();
		KMP();

		System.out.println("#" + testNo + " " + result);
	}

	private static void getPi() {
		int pLen = pattern.length();
		char[] p = pattern.toCharArray(); // ababa , 00120
		int j = 0;

		for (int i = 1; i < pLen; ++i) {
			while (j > 0 && p[i] != p[j])
				j = pi[j - 1];
			if (p[i] == p[j])
				pi[i] = ++j;
		}
	}

	private static void KMP() {
		int oLen = origin.length();
		int pLen = pattern.length();

		char[] o = origin.toCharArray();
		char[] p = pattern.toCharArray();

		int j = 0;

		for (int i = 0; i < oLen; ++i) {
			while (j > 0 && o[i] != p[j])
				j = pi[j-1];

			if (o[i] == p[j]) {
				if (j == pLen - 1) {
					++result;
					j = pi[j];
				} else {
					++j;
				}
			}
		}
	}
}
