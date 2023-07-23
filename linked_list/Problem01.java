package linked_list;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Problem01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= 1; ++test_case) {
			int N = sc.nextInt();
			sc.nextLine();
			List<Integer> list = new LinkedList<>();
			String[] code = sc.nextLine().split(" ");
			for (String v : code) {
				list.add(Integer.parseInt(v));
			}

			int cmd_count = sc.nextInt();
			sc.nextLine();
			String[] cmd = sc.nextLine().split(" ");
			int idx = 0;
			while (idx < cmd.length) {
				if (cmd[idx].equals("I")) {
					int x = Integer.parseInt(cmd[idx + 1]);
					int y = Integer.parseInt(cmd[idx + 2]);
					for (int i = idx + 3; i < idx + y + 3; ++i) {
						list.add(x + 1, Integer.parseInt(cmd[i]));
					}
					idx += y + 3;
				} else if (cmd[idx].equals("D")) {
					int x = Integer.parseInt(cmd[idx + 1]);
					int y = Integer.parseInt(cmd[idx + 2]);
					for (int i = 0; i < y; i++)
						list.remove(x);
					idx += 3;
				} else {
					int y = Integer.parseInt(cmd[idx + 1]);
					for (int i = idx + 2; i < idx + y + 2; ++i) {
						list.add(Integer.parseInt(cmd[i]));
					}
					idx += y + 2;
				}
			}
			System.out.print("#" + test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
	}
}
