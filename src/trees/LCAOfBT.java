package trees;

public class LCAOfBT {

	static Node root;

	static class Node {

		int val;

		Node left, right = null;

		public Node(int val) {
			this.val = val;
		}
	}

	Node result = null;

	public Node lowestCommonAncestor(Node root, Node p, Node q) {

		if (root == null) {
			return null;
		}

		if (root.val == p.val || root.val == q.val) {
			return root;
		}

		Node left = lowestCommonAncestor(root.left, p, q);
		Node right = lowestCommonAncestor(root.right, p, q);

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
		
//		root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(-99);
//		root.right.left = new TreeNode(-99);
//		root.right.right = new TreeNode(7);
//		root.left.left.left = new TreeNode(8);
//		root.left.left.right = new TreeNode(9);
//		root.left.right.left = new TreeNode(-99);
//		root.left.right.right = new TreeNode(-99);
//		root.right.left.left = new TreeNode(12);
//		root.right.left.right = new TreeNode(13);
//		root.right.right.left = new TreeNode(-99);
//		root.right.right.right = new TreeNode(14);
		
		Node temp = root;
		System.out.println(new LCAOfBT().lowestCommonAncestor(temp, new Node(4), new Node(7)).val);
	}
}
