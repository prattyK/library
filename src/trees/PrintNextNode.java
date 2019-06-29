package trees;

public class PrintNextNode {

	static Node root;

	static class Node {

		int data;
		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void printNextNode(int data) {
		Node temp = root;

		int h = getHeight(temp);

		for (int i = 1; i <= h; i++) {
			printNextNode(temp, data, i, false);
		}

	}

	static boolean result = false;

	public static void printNextNode(Node temp, int data, int level, boolean next) {

		if (temp == null) {
			return;
		}

		if (level == 1 && temp.data == data) {
			result = true;
		}

		if (level == 1 && next) {
			System.out.println(temp.data);
			result = false;
			return;
		}
		if (level > 1) {
			printNextNode(temp.left, data, level - 1, result);
			printNextNode(temp.right, data, level - 1, result);
		}

	}

	public static int getHeight(Node temp) {
		if (temp == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(temp.left), getHeight(temp.right));
	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);
		printNextNode(11);
	}

}
