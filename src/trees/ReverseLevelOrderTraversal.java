package trees;

public class ReverseLevelOrderTraversal {

	static Node root;

	static class Node {
		int data;
		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void printNodeGivenLevel() {

		Node temp = root;

		int h = height(temp);

		for (int i = h; i >= 1; i--) {
			printReverseLevelOrderTraversal(temp, i);
		}

	}

	public static void printReverseLevelOrderTraversal(Node n, int level) {

		if (n == null) {
			return;
		}

		if (level == 1) {
			System.out.println(n.data);
		} else {

			printReverseLevelOrderTraversal(n.left, level - 1);

			printReverseLevelOrderTraversal(n.right, level - 1);
		}
	}

	public static int height(Node n) {

		if (n == null) {
			return 0;
		}

		return 1 + Math.max(height(n.left), height(n.right));
	}

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		printNodeGivenLevel();
	}

}
