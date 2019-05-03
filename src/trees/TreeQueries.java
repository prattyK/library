package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeQueries {

	static Node root;

	static class Node {

		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	public static void treeQueries(int query, Scanner sc) {

		switch (query) {

		case 1:
			Node temp = root;
            printLevelNode(temp, sc.nextInt(), sc.nextInt());
//			if (result != null) {
//				return result.data;
//			}
			break;

		case 2:
			System.out.println(sumOfNodes(sc.nextInt(), sc.nextInt()));

		case 3:
			Node temp1 = root;
			Node n = findNode(temp1, sc.nextInt(), 1, sc.nextInt());
			if (n != null) {
				n.data = sc.nextInt();
//				return n.data;
			}
			break;

		}
//		return query;
	}

	private static int sumOfNodes(int level1, int level2) {

		Node temp = root;

		return sumOfNodeOfLevel(temp, 1, level1, level2);

	}

	private static int sumOfNodeOfLevel(Node head, int initialLevel, int level1, int level2) {
		if (head == null) {
			return 0;
		}
		if (initialLevel >= level1 && initialLevel <= level2) {
			return head.data + sumOfNodeOfLevel(head.left, initialLevel + 1, level1, level2)
					+ sumOfNodeOfLevel(head.right, initialLevel + 1, level1, level2);
		}
		return 0;
	}

	private static Node createTree(Node actual) {

		if (latestNode.isEmpty()) {
			latestNode.add(actual);
			root = actual;
			return root;
		} else {
			Node temp = latestNode.peek();

			if (temp.left != null && temp.right != null) {
				latestNode.poll();
				temp = latestNode.peek();
			}

			if (temp != null) {
				latestNode.add(actual);
				Node temp1 = root;
				Node findNode = findNode(temp1, temp);
				if (findNode != null) {
					if (findNode.left == null) {
						findNode.left = actual;
					} else {
						findNode.right = actual;
					}

				}

			}

		}

		return root;
	}

	private static Node findNode(Node temp, Node searchNode) {

//		Node temp = root;

		if (temp == null) {
			return null;
		}

		if (temp.data == searchNode.data) {
			return searchNode;
		}
		findNode(temp.left, searchNode);
		findNode(temp.right, searchNode);

		return searchNode;

	}

	private static Node findNode(Node temp, int data, int initalLevel, int level) {

		if (temp == null) {
			return temp;
		}

		if (initalLevel == level && data == temp.data) {
			return temp;
		}

		findNode(temp.left, data, initalLevel + 1, level);

		findNode(temp.right, data, initalLevel, level);

		return temp;
	}

	static int index = 0;
	private static Node printLevelNode(Node temp, int data, int level) {
		if (temp == null) {
			return temp;
		}

		if (level == 1) {
			index++;
			if (data == index) {
				System.out.println(temp.data);
//				index = 0;
				return temp;
			}
			
		} 
		
		
		printLevelNode(temp.left, data,level -1);

		printLevelNode(temp.right, data, level -1);

		return temp;
	}

	static Queue<Node> latestNode = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrSize = sc.nextInt();
		int queryCount = sc.nextInt();

		for (int i = 0; i <= arrSize - 1; i++) {
			int data = sc.nextInt();
			Node actual = new Node(data, null, null);
//			Node temp = root;
			root = createTree(actual);
		}

		for (int i = 0; i <= queryCount - 1; i++) {
			treeQueries(sc.nextInt(), sc);
		}

		sc.close();
	}

}
