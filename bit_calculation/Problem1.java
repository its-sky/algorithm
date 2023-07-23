package bit_calculation;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; ++test_case) {
			int N = sc.nextInt();
			int bit = 0, target = 0;
			while (true) {
				target += N;
				int length = (int)(Math.log10(target)+1);
				int tmp_target = target;
				for (int i = 0; i < length; i++) {
					int tmp = tmp_target % 10;
					tmp_target /= 10;
					bit = (bit | (1 << tmp));
				}
				if ((bit ^ 1023) == 0)
					break;
			}
			System.out.println("#" + test_case + " " + target);
		}
	}
}
