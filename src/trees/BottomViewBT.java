package trees;

import java.util.LinkedHashMap;
import java.util.Map;

class BottomViewBT {

	static Node root = null;
	static Map<Integer, Integer> result = new LinkedHashMap<>();

	static class Node {

		int data;
		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	/*
	 * horizontal for left = hd-1 
	 * horizontal for right = hd+1
	 * Add node data as value along with horizontal distance as key
	 */
	public static void bottomView(Node temp, int hd) {

		if (temp == null) {
			return;
		}
		result.put(hd, temp.data);
		bottomView(temp.left, hd - 1);
		bottomView(temp.right, hd + 1);
	}

	/*
	 * Iterate result collection and print
	 * 
	 */
	public static void printResult() {

		if (!result.isEmpty()) {

			for (int data : result.values()) {
				System.out.println(data);
			}
		}

	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);
		bottomView(root, 0);
		printResult();
	}
}