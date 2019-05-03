package trees;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BottomTopTreeOrder {

	static Node root;

	static class Node {

		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	static Map<Integer, LinkedList<Node>> result = new LinkedHashMap<>();

	private static void printBottomToTop() {

		Node temp = root;
		int level = 1;
		LinkedList<Node> lt1 = new LinkedList<>();
		lt1.add(temp);
		result.put(level, lt1);
		qLeft.add(temp.left);
		qRight.add(temp.right);

		while (!qLeft.isEmpty()) {

			level++;

			int n = qLeft.size();

			while (n-- > 0) {

				Node left = qLeft.poll();
				Node right = qRight.poll();
				if (result.get(level) != null) {
					result.get(level).add(left);
					result.get(level).add(right);
				} else {
					lt1 = new LinkedList<>();
					lt1.add(left);
					lt1.add(right);
					result.put(level, lt1);
				}

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

		for (int i = result.size(); i >= 1; i--) {

			LinkedList<Node> result1 = result.get(i);
			
			for(Node k : result1) {
				System.out.println(k.data);
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
		printBottomToTop();

	}
}