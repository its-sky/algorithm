package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Intersection {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			sb.append("#").append(t).append(" ");
			int res = 0;
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			ArrayList<String> list = new ArrayList<>();
			HashSet<String> set = new HashSet<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < a; ++i) {
				list.add(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < b; ++i) {
				set.add(st.nextToken());
			}

			for (int i = 0; i < a; ++i) {
				if (set.contains(list.get(i)))
					++res;
			}

			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
}
