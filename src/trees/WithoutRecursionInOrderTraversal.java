package trees;

import java.util.Stack;

public class WithoutRecursionInOrderTraversal {

	private static Node root;
	private Stack<Node> input = new Stack<>();

	private void inorderTreeWalk() {

		if (root == null) {
			return;
		}

		Node curr = root;

		while (curr != null || !input.isEmpty()) {

			while (curr != null) {

				input.push(curr.getLeft());
				curr = curr.getLeft();
			}
			
			curr =input.pop();
			
			curr = curr.getRight();

		}

	}

	public static void main(String[] args) {
		
		WithoutRecursionInOrderTraversal input = new WithoutRecursionInOrderTraversal();
		
		Node parent = new Node(1);
		Node leftNode = new Node(2);
		leftNode.setLeft(new Node(4));
		leftNode.setRight(new Node(5));
		parent.setLeft(leftNode);
		parent.setRight(new Node(3));
		root = parent;
		input.inorderTreeWalk();
		
	}

}
