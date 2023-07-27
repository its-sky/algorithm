package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Words {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			sb.append("#").append(t).append(" ");
			String book = br.readLine();
			String word = br.readLine();
			HashMap<String, Integer> map = new HashMap<>();
			char first = word.charAt(0);
			int word_length = word.length();

			for (int i = 0; i <= book.length() - word.length(); ++i) {
				String key = book.substring(i, i + word_length);
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
			sb.append(map.get(word)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
