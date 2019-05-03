package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBT {

	static Node root;

	static class Node {

		int data;
		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void printLeftView() {

		Node temp = root;

		int h = height(temp);

		for (int i = 1; i <= h; i++) {

			printLeftView(i, temp);

			System.out.println(result.poll());
		}

	}

	static Queue<Integer> result = new LinkedList<>();

	public static void printLeftView(int level, Node temp) {

		if (temp == null) {
			return;
		}

		if (level == 1 && result.isEmpty()) {
			result.add(temp.data);
		} else {
			printLeftView(level - 1, temp.left);
			printLeftView(level - 1, temp.right);
		}

	}

	public static int height(Node temp) {
		if (temp == null) {
			return 0;
		}
		return 1 + Math.max(height(temp.left), height(temp.right));
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
		printLeftView();
	}

}
