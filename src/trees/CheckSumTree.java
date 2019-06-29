package trees;

public class CheckSumTree {

	static Node root;

	static class Node {

		int data;
		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	private static int checkSumTree(Node temp) {

		if (temp == null) {
			return 0;
		}

		if (temp.left == null && temp.right == null) {
			return temp.data;
		}

		if (temp.data == checkSumTree(temp.left) + checkSumTree(temp.right)) {
			return 2 * temp.data;
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {

		root = new Node(44);
		root.left = new Node(9);
		root.right = new Node(13);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		if(checkSumTree(root) == Integer.MIN_VALUE) {
			System.out.println(false);
		}else {
			System.out.println(true);
		}
	}

}
