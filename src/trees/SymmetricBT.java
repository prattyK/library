package trees;

public class SymmetricBT {

	static Node root;

	static Node root1;
	static class Node {
		int data;
		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	private static boolean isSymmetric(Node temp1, Node temp2) {
		if (temp1 == null && temp2 == null) {
			return true;
		}
		return temp1!=null && temp2!=null && isSymmetric(temp1.left, temp2.right) && isSymmetric(temp1.right, temp2.left);
	}

	public static void main(String[] args) {
//		root = new Node(1);
//		root.left = new Node(2);
//		root.right = new Node(3);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.left.right.left = new Node(15);
//		root.right.left = new Node(6);
//		root.right.right = new Node(7);
//		root.right.right.left = new Node(9);
		
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(1);
		
		root1 = new Node(1);
		root1.left = new Node(1);
		root1.right = new Node(2);
		System.out.println(isSymmetric(root, root1));
	}

}
