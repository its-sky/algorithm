package tree;

import java.util.Scanner;

public class Operation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; ++test_case) {
			int N = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				String[] tmp = sc.nextLine().split(" ");
				if (tmp.length > 2 && !(tmp[1].equals("+") || tmp[1].equals("-") ||
						tmp[1].equals("*") || tmp[1].equals("/"))) {
					System.out.println("#1 0");
					continue;
				} else if (tmp.length == 2 && (tmp[1].equals("+") || tmp[1].equals("-") ||
						tmp[1].equals("*") || tmp[1].equals("/"))) {
					System.out.println("#1 0");
					continue;
				} else if (tmp.length == 3) {

				}
			}
			System.out.println("#1 1");
		}
	}
}
