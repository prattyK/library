package trees;

import java.util.LinkedList;
import java.util.Queue;

public class TopDownTreeOrder {

	static Node root;

	static class Node {

		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	private static void printTopToBottom() {

		Node temp = root;
		System.out.println(temp.data);
		qLeft.add(temp.left);
		qRight.add(temp.right);

		while (!qLeft.isEmpty()) {

			Node left = qLeft.poll();
			Node right = qRight.poll();
			System.out.println(left.data);
			System.out.println(right.data);

			if (left.left != null && right.right != null) {
				qLeft.add(left.left);
				qRight.add(right.right);
			}

			if (right.left != null && left.right != null) {
				qLeft.add(left.right);
				qRight.add(right.left);
			}

		}

	}

	static Queue<Node> qLeft = new LinkedList<>();
	static Queue<Node> qRight = new LinkedList<>();

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
		printTopToBottom();

	}

}
