package trees;

public class CheckSubTree {

	static Node root;

	static class Node {
		int data;
		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	private static boolean checkSubTree(Node root, Node subtree) {

		String mainRoot = preOrder(root, false);
		String subTree = preOrder(subtree, false);

		if (mainRoot.indexOf(subTree) == -1) {
			return false;
		} else {
			return true;
		}

	}

	private static String preOrder(Node temp, boolean left) {

		if (temp == null) {

			if (left) {
				return "lLnull";
			} else {
				return "rRnull";
			}
		}
		return "#" + temp.data + "" + preOrder(temp.left, true) + "" + preOrder(temp.right, false);
	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		Node subtree = new Node(3);
		subtree.left = new Node(6);
		subtree.right = new Node(7);
		System.out.println(checkSubTree(subtree, subtree));
		
	}

}
