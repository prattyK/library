package trees;

public class BinrayTreeHieght {

	static Node root;

	public static int getHieght(Node root) {

		if (root == null) {
			return -1;
		}

		int leftHeight = getHieght(root.getLeft());
		int rightHeight  = getHieght(root.getRight());
		
		return 1 + Math.max(leftHeight,rightHeight);
	}

	public static void main(String[] args) {
		root = BST.insert(root, new Node(3));
		root = BST.insert(root, new Node(1));
		root = BST.insert(root, new Node(7));
		root = BST.insert(root, new Node(5));
		root = BST.insert(root, new Node(4));
		System.out.println(getHieght(root));
	}

}
