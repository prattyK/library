package com.elementryds;

public class BinarySearchTree {

	static class Node {
		int data;
		Node left;
		Node right;
		Node parent;

		Node(int data) {
			this.data = data;
		}

	}

	public static int binaryTreeSearch(Node root, int key) {

		if (key == 0 || key == root.data) {

			return key;
		}

		if (key < root.data) {
			binaryTreeSearch(root.left, key);
		} else {
			binaryTreeSearch(root.right, key);
		}

		return 0;

	}

	public static Node minimumBST(Node root) {

		if (root.left == null) {
			System.out.println("Minimum: = " + root.data);
			return root;
		}

		return minimumBST(root.left);
	}

	public static Node maxBST(Node root) {

		if (root.right == null) {
			System.out.println("Maximum: = " + root.data);
			return root;
		}

		return maxBST(root.right);
	}

	public static Node insertionInBST(Node root, int z) {

		Node y = null;
		Node x = root;

		while (x != null) {

			y = x;

			if (z < x.data) {

				x = x.left;

			} else {
				x = x.right;
			}

		}

		if (y == null) {
			root = new Node(z);
		} else if (z < y.data) {
			y.left = new Node(z);
		} else {
			y.right = new Node(z);
		}
		return root;
	}

	public static Node successorOfBst(Node x) {

		if (x.right != null) {
			return minimumBST(x.right);
		}

		Node y = x.parent;

		while (y != null && x == y.right) {

			x = y;
			y = y.parent;
		}

		return y;
	}

	
	//Not right implementation 
	public static Node deletionOfBST(Node root, int key) {

		if (root == null) {
			return root;
		}

		if (root.data > key) {

			root.left = deletionOfBST(root.left, key);

		} else if (root.data < key) {

			root.right = deletionOfBST(root.right, key);
		} else {

			if (root.left == null) {

				return root.right;

			} else if (root.right == null) {

				return root.left;
			}

			root = minimumBST(root.right);

			root.right = deletionOfBST(root.right, root.data);
		}
		return root;
	}

	public static void main(String[] args) {

		Node childLeftNode = new Node(3);
		childLeftNode.left = new Node(2);
		childLeftNode.right = new Node(4);

		Node childRightNode = new Node(7);
		childRightNode.right = new Node(13);

		Node node = new Node(15);
		Node leftNode = new Node(6);
		leftNode.left = childLeftNode;
		leftNode.right = childRightNode;

		Node rightNode = new Node(18);
		rightNode.left = new Node(17);
		rightNode.right = new Node(20);

		node.left = leftNode;
		node.right = rightNode;

//		minimumBST(node);
//		maxBST(node);
		Node temp = deletionOfBST(node, 6);
		System.out.println(temp);
	}

}
