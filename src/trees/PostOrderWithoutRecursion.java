package trees;

import java.util.Stack;

public class PostOrderWithoutRecursion {

	static Node root;

	static class Node {

		int data;
		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void postOrder(Node root) {

		Stack<Node> rootStack = new Stack<>();

		Node temp = root;

		rootStack.add(root);

		while (!rootStack.isEmpty() && root != null) {

			root = rootStack.peek();

			if ((root.left == null && root.right == null) || (temp == root.left || temp == root.right)) {

				root = rootStack.pop();

				System.out.print(root.data + " ");

				temp = root;

			} else {

				if (root.right != null) {

					rootStack.add(root.right);
				}

				if (root.left != null) {

					rootStack.add(root.left);

				}
			}
		}

	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);
		
		postOrder(root);
	}

}
