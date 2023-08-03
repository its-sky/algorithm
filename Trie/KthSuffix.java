package Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class KthSuffix {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			int K = Integer.parseInt(br.readLine());
			String str = br.readLine();

			ArrayList<String> arr = new ArrayList<>();
			int length = str.length();
			for (int i = 1; i <= str.length(); ++i) {
				arr.add(str.substring(length - i, length));
			}
			Collections.sort(arr);
			sb.append(arr.get(K - 1)).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
