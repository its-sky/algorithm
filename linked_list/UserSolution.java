package linked_list;

public class UserSolution {

	static class Node {
		public int data;
		public Node prev;
		public Node next;

		public Node() {}

		public Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	private final static int MAX_NODE = 10000;

	private Node[] node = new Node[MAX_NODE];
	private int nodeCnt = 0;
	private Node head;

	public Node getNode(int data) {
		node[nodeCnt] = new Node(data);
		return node[nodeCnt++];
	}

	public void init() {
		head = new Node();
	}

	public void addNode2Head(int data) {
		Node new_node = getNode(data);
		new_node.prev = head;
		new_node.next = head.next;
		if (new_node.next != null)
			new_node.next.prev = new_node;
		head.next = new_node;
	}

	public void addNode2Tail(int data) {
		Node curr = head;
		while (curr.next != null)
			curr = curr.next;
		Node new_node = new Node(data);
		new_node.prev = curr;
		curr.next = new_node;
	}

	public void addNode2Num(int data, int num) {
		Node curr = head;
		for (int i = 1; i < num; ++i)
			curr = curr.next;
		Node new_node = getNode(data);
		new_node.next = curr.next;
		new_node.prev = curr;
		if (new_node.next != null)
			new_node.next.prev = new_node;
		curr.next = new_node;
		int[] rev = new int[5];
	}

	public int findNode(int data) {
		Node curr = head;
		int turn = 0;
		while (curr.next != null) {
			++turn;
			curr = curr.next;
			if (curr.data == data) {
				break;
			}
		}
		return turn;
	}

	public void removeNode(int data) {
		Node curr = head;
		while (curr.next != null) {
			if (curr.next.data == data) {
				curr.next.next.prev = curr;
				curr.next = curr.next.next;
				return;
			}
		}
	}

	public int getList(int[] output) {
		Node curr = head;
		int res = 0;
		while (curr.next != null) {
			curr = curr.next;
			output[res++] = curr.data;
		}
		return res;
	}

	public int getReversedList(int[] output) {
		Node curr = head;
		int res = 0;
		while (curr.next != null)
			curr = curr.next;
		while (curr.prev != head) {
			output[res++] = curr.data;
			curr = curr.prev;
		}
		output[res++] = curr.data;
		return res;
	}
}