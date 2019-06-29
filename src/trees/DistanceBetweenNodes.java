package trees;

public class DistanceBetweenNodes {

	static Node root;

	static class Node {
		int data;
		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}

	}

	private static int levelOfNode(int data, Node temp, int level) {

		if (temp == null) {
			return 0;
		}

		if (data == temp.data) {
			return level;
		}
		int downLevel = levelOfNode(data, temp.left, level + 1);
		if (downLevel != 0) {
			return downLevel;
		}
		downLevel = levelOfNode(data, temp.right, level + 1);
		return downLevel;
	}

	private static Node findLcaofNode(int n1, int n2, Node temp) {
		if (temp == null) {
			return null;
		}

		if (temp.data == n1 || temp.data == n2) {
			return temp;
		}

		Node left = findLcaofNode(n1, n2, temp.left);
		Node right = findLcaofNode(n1, n2, temp.right);

		if (left != null && right != null) {
			return temp;
		}
		return left == null ? right : left;
	}

	private static int calculateDistanceOfTwoNode(Node temp, int n1, int n2) {

		int dN1 = levelOfNode(n1, temp, 1);
		int dN2 = levelOfNode(n2, temp, 1);
		Node lca = findLcaofNode(n1, n2, temp);
		int lcaD3 = levelOfNode(lca.data, temp, 1);
		return dN1 + dN2 - 2 * lcaD3;
	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
//		root.left.left.left = new Node(8);
//		root.left.left.right = new Node(9);
//		root.left.right.left = new Node(10);
//		root.left.right.right = new Node(11);
//		root.right.left.left = new Node(12);
//		root.right.left.right = new Node(13);
//		root.right.right.left = new Node(14);
//		root.right.right.right = new Node(15);
		Node temp = root;
		System.out.println(calculateDistanceOfTwoNode(temp, 4, 6));
	}

}
