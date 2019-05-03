package trees;

public class LCAOfBT {

	static Node root;
	
	static class Node {

		int data;

		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	public  static Node lowestCommonAncestor(Node root, Node one, Node two) {

		if (root == null) {
			return null;
		}
		if (root.data == one.data || root.data == two.data) {
			return root;
		}

		Node left = lowestCommonAncestor(root.left, one, two);
		Node right = lowestCommonAncestor(root.right, one, two);
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
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
		root.left.right.right = new Node(11);
//		root.right.left.left = new Node(12);
//		root.right.left.right = new Node(13);
//		root.right.right.left = new Node(14);
//		root.right.right.right = new Node(15);
		Node temp = root;
		System.out.println(lowestCommonAncestor(temp, new Node(4), new Node(11)).data);
	}
}
