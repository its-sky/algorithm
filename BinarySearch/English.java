package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class English {
	static int[] days;
	static int[] blanks;
	static int maxPeriod;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			maxPeriod = 0;

			days = new int[N];
			blanks = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				days[i] = Integer.parseInt(st.nextToken());
			}
			int blankCount = 0;
			for (int i = 0; i < N - 1; ++i) {
				blankCount += days[i + 1] - days[i] - 1;
				blanks[i + 1] = blankCount;
			}

			binary_search(N, P);
			sb.append(maxPeriod).append("\n");
		}
		System.out.print(sb);
	}

	private static void binary_search(int n, int p) {
		for (int i = 0; i < n; ++i) {
			int start = i, end = n - 1;
			int answer = 0;
			while (start <= end) {
				int mid = start + (end - start) / 2;
				int didntStudy = blanks[mid] - blanks[i];
				int curP = (p - didntStudy > 0) ? p - didntStudy : 0;

				if (didntStudy > p) end = mid - 1;
				else {
					answer = days[mid] - days[i] + 1 + curP;
					start = mid + 1;
				}
			}
			if (maxPeriod < answer)
				maxPeriod = answer;
		}
	}
}
