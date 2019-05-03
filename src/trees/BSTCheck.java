package trees;

public class BSTCheck {

	static Node root;

	public boolean checkBst(Node head, int min, int max) {

		if (head == null) {
			return true;
		}

		if (head.getVal() <= min && head.getVal() > max) {
			return false;
		}

		return checkBst(head.getLeft(), min, head.getVal()) && checkBst(head.getRight(), head.getVal(), max);
	}

	public static void main(String[] args) {

//		BST bst = new BST();

		root = BST.insert(root, new Node(1));
		root = BST.insert(root, new Node(2));
		root = BST.insert(root, new Node(3));
		root = BST.insert(root, new Node(4));
		root = BST.insert(root, new Node(5));
		root = BST.insert(root, new Node(0));
		root = BST.insert(root, new Node(10));

		System.out.println("Result :" + new BSTCheck().checkBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

}
