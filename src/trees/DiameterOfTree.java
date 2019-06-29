package trees;

import java.util.concurrent.atomic.AtomicInteger;

public class DiameterOfTree {

	static Node root;

	static class Node {
		int data;
		Node left = null, right = null;

		Node(int data) {
			this.data = data;
		}
	}

	int result;

	public int diameterOfBinaryTree(Node root) {
		result = 1;
		longestHeight(root);
		return result - 1;
	}

	private int longestHeight(Node root) {

		if (root == null) {
			return 0;
		}

		int left = longestHeight(root.left);
		int right = longestHeight(root.right);
		result = Math.max(result, left + right + 1);
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);

//		AtomicInteger diameter = new AtomicInteger(0);
//		getDiameter(root, diameter);
		System.out.print("The diameter of the tree is " + new DiameterOfTree().diameterOfBinaryTree(root));
	}
}