package Heap;

public class UserSolution {
	public static int[] tree;
	public static int[] uID_list;
	public static int MAX_USER_SIZE = 100001;
	public static int curr = 1;

	public void init() {
		tree = new int[MAX_USER_SIZE];
		uID_list = new int[MAX_USER_SIZE];
	}

	public void addUser(int uID, int income) {
		tree[curr] = income;
		uID_list[curr++] = uID;
		System.out.println("uID : " + uID);
		sortTree(curr - 1);
	}

	private void sortTree(int idx) {
		while (true) {
			if (idx == 1)
				return;

			if (tree[idx] > tree[idx / 2]) {
				swap(idx, idx / 2);
				idx = idx / 2;
			} else {
				return;
			}
		}
	}

	private void removeMax() {
		tree[1] = tree[curr - 1];
		uID_list[1] = uID_list[curr - 1];
		--curr;

		int idx = 1;
		while (true) {
			if (idx*2 > curr - 1 || idx*2 + 1 > curr - 1)
				return;
			if (tree[idx] < tree[idx*2]) {
				if (tree[idx] < tree[idx*2 + 1]) {
					if (tree[idx*2] == tree[idx*2 + 1]) {
						swap(idx, idx*2);
						idx = idx*2;
					} else if (tree[idx*2] > tree[idx*2 + 1]) {
						swap(idx, idx*2);
						idx = idx*2;
					} else {
						swap(idx, idx*2+1);
						idx = idx*2+1;
					}
				} else {
					swap(idx, idx*2);
					idx = idx*2;
				}
			} else {
				if (tree[idx] < tree[idx*2 + 1]) {
					swap(idx, idx*2+1);
					idx = idx*2+1;
				} else {
					return;
				}
			}
		}
	}

	private static void swap(int idx1, int idx2) {
		int tmp = tree[idx1];
		tree[idx1] = tree[idx2];
		tree[idx2] = tmp;
		tmp = uID_list[idx1];
		uID_list[idx1] = uID_list[idx2];
		uID_list[idx2] = tmp;
	}

	int getTop10(int[] result) {
		int size = 0;
		for (int i = 0; i < 10; ++i) {
			if (curr > 1) {
				result[i] = uID_list[1];
				System.out.println("max:" + result[i]);
				removeMax();
				++size;
			} else {
				break;
			}
		}
		System.out.println("size:" + size);
		return size;
	}
}
