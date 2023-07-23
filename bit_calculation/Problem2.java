package bit_calculation;

import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; ++test_case) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int mode = 0;

			String tmp = Integer.toBinaryString(M);
			int size = tmp.length() - N;
			if (size < 0) {
				System.out.println("#" + test_case + " OFF");
				continue;
			}
			tmp = tmp.substring(size);
			for (char c : tmp.toCharArray()) {
				if (c == '0') {
					System.out.println("#" + test_case + " OFF");
					mode = 1;
					break;
				}
			}
			if (mode == 0) {
				System.out.println("#" + test_case + " ON");
			}
		}
	}
}


// 1 2 3 4