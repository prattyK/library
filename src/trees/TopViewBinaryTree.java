package trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class TopViewBinaryTree {

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	/*
	 * 
	 * class Node int data; Node left; Node right;
	 */

	static Queue<Visited> nodes = new LinkedList<>();
	static Map<Integer, Visited> verticalCollection = new TreeMap<>();

	static class Visited {

		Node n;
		int level;

		public Visited(Node n, int level) {
			this.n = n;
			this.level = level;
		}

		public Node getN() {
			return n;
		}

		public void setN(Node n) {
			this.n = n;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

	}

	public static void topView(Node root) {

		Node temp = root;
		nodes.add(new Visited(temp, 0));

		while (!nodes.isEmpty()) {

			Visited peek = nodes.poll();

			if (verticalCollection.get(peek.getLevel()) == null) {
				verticalCollection.put(peek.getLevel(), peek);
			}

			if (peek.getN().left != null) {
				nodes.add(new Visited(peek.getN().left, peek.getLevel() - 1));
			}

			if (peek.getN().right != null) {
				nodes.add(new Visited(peek.getN().right, peek.getLevel() + 1));
			}
		}
		
		for(Visited m :verticalCollection.values()) {
			
			System.out.println(m.getN().data+" ");
		}

	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		topView(root);
	}
}
