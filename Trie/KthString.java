package Trie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KthString {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			int K = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String[] suffixArray = new String[str.length()];
			int[] LCP = new int[str.length()];

			for (int i = 0; i < str.length(); ++i) {
				suffixArray[i] = str.substring(i);
			}
			Arrays.sort(suffixArray);
			LCP[0] = 0;
			for (int i = 1; i < str.length(); ++i) {
				String prev = suffixArray[i - 1];
				String curr = suffixArray[i];
				int j = 0;
				while (j < prev.length() && j < curr.length() && prev.charAt(j) == curr.charAt(j)) ++j;
				LCP[i] = j;
			}

			int subCnt = 0;
			for (int i = 0; i < str.length(); ++i) {
				subCnt += suffixArray[i].length() - LCP[i];
				if (subCnt >= K) {
					sb.append(suffixArray[i].substring(0, suffixArray[i].length() - (subCnt - K))).append("\n");
					break;
				}
			}
			if (subCnt < K) sb.append("none\n");
		}
		System.out.print(sb);
		br.close();
	}
}
