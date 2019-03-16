package com.elementryds;

public class RedBlackTreeImp {

	Node root;

	static class Node {

		Node right;
		Node left;
		Node parent;
		int data;
		String color;

		Node(int d) {
			this.data = d;
		}
	}

	public Node insert(int key) {

		Node x = root;

		Node insertionNode = new Node(key);
		Node y = null;
		while (x != null) {

			y = x;
			if (insertionNode.data < x.data) {
				x = x.left;
			} else {

				x = x.right;
			}

		}

		insertionNode.parent = y;

		if (y == null) {

			return root = insertionNode;
		} else if (insertionNode.data < y.data) {

			y.left = insertionNode;

		} else {

			y.right = insertionNode;

		}

		insertionNode.color = "RED";
		return insertionFixUp(root, insertionNode);

	}

	public Node leftRotate(Node root, Node key) {

		Node y = key.right;

		key.right = y.left;

		if (y.left != null) {

			y.left.parent = key;

			y.parent = key.parent;
		}

		if (key.parent == null) {

			root = y;

		} else if (key == key.parent.left) {

			key.parent.left = y;

		} else {

			key.parent.right = y;
			y.left = key;
			key.parent = y;

		}

		return root;
	}

	public Node rightRotate(Node root, Node y) {

		Node x = y.left;

		y.left = x.right;

		if (x.right != null) {

			x.right.parent = y;

		}

		x.parent = y.parent;

		if (y.parent == null) {

			root = x;

		} else if (y == y.parent.left) {

			y.parent.left = x;

		} else {

			y.parent.right = x;
			x.right = y;
			y.parent = x;

		}

		return y;

	}

	public Node insertionFixUp(Node root, Node z) {

		Node y = null;

		while (z.parent.color.equalsIgnoreCase("RED")) {

			if (z.parent == z.parent.parent.left) {

				y = z.parent.parent.right;

				if (y.color.equalsIgnoreCase("RED")) {

					z.parent.color = "BLACK";
					y.color = "BLACK";
					z.parent.parent.color = "RED";
					z = z.parent.parent;
				} else if (z == z.parent.right) {

					z = z.parent;
					leftRotate(root, z);

				} else {
					z.parent.color = "BLACK";
					z.parent.parent.color = "RED";
					rightRotate(root, z.parent.parent);

				}
			} else {

				y = z.parent.parent.left;

				if (y.color.equalsIgnoreCase("RED")) {

					z.parent.color = "BLACK";
					y.color = "BLACK";
					z.parent.parent.color = "RED";
					z = z.parent.parent;

				} else if (z == z.parent.left) {

					z = z.parent;
					rightRotate(root, z);
					z.parent.color = "BLACK";
					z.parent.parent.color = "RED";
					leftRotate(root, z.parent.parent);

				}

			}
		}

		root.color = "BLACK";
		return root;

	}

	public static void main(String[] args) {

	}

}
