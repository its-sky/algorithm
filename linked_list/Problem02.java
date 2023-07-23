package linked_list;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Problem02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; ++test_case) {
			List<Integer> list = new LinkedList<>();
			int N = sc.nextInt();
			int M = sc.nextInt();
			int L = sc.nextInt();
			sc.nextLine();
			String[] st = sc.nextLine().split(" ");
			for (String tmp : st) {
				list.add(Integer.parseInt(tmp));
			}
			for (int i = 0; i < M; i++) {
				String[] tmp = sc.nextLine().split(" ");
				if (tmp[0].equals("I")) {
					int idx = Integer.parseInt(tmp[1]);
					int value = Integer.parseInt(tmp[2]);
					list.add(idx, value);
				} else if (tmp[0].equals("D")) {
					int idx = Integer.parseInt(tmp[1]);
					list.remove(idx);
				} else if (tmp[0].equals("C")) {
					int idx = Integer.parseInt(tmp[1]);
					int value = Integer.parseInt(tmp[2]);
					list.set(idx, value);
				}
			}
			if (list.size() > L)
				System.out.println("#" + test_case + " " + list.get(L));
			else
				System.out.println("#" + test_case + " -1");
		}
	}
}
