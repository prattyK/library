package trees;

import java.util.Stack;

public class PreOrderWihoutRecursion {

	static Node root = null;

	static class Node {
		int data;
		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void preOrderTraversal() {
		Node temp = root;
		Stack<Node> result = new Stack<>();
		result.add(temp);

		while (!result.isEmpty()) {
			Node current = result.pop();
			System.out.println(current.data);

			if (current.right != null) {
				result.add(current.right);
			}

			if (current.left != null) {
				result.add(current.left);
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
//		root.left.left.left = new Node(8);
//		root.left.left.right = new Node(9);
//		root.left.right.left = new Node(10);
//		root.left.right.right = new Node(11);
//		root.right.left.left = new Node(12);
//		root.right.left.right = new Node(13);
//		root.right.right.left = new Node(14);
//		root.right.right.right = new Node(15);
		preOrderTraversal();
	}

}
