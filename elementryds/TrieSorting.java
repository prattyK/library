package com.elementryds;

public class TrieSorting {

	static final int alphabetSize = 26;

	static Node node;

	static class Node {

		Node[] children = new Node[alphabetSize];
		boolean wordEnd;
		char data;

		Node(char data) {
			this.data = data;
		}

	}

	public static void insert(String key) {

		Node tempNode = node;

		for (int level = 0; level < key.length(); level++) {

			int index = key.charAt(level) - 'a';

			if (tempNode.children[index] == null) {

				tempNode.children[index] = new Node(key.charAt(level));

			}

			tempNode = tempNode.children[index];

		}

		tempNode.wordEnd = true;

	}

	public static void preOrderTraersal(Node root, StringBuilder sb) {

		Node temp = root;

		if (temp == null) {
			return;
		}

		if (temp.wordEnd) {
			System.out.println(sb);
		}
		
		if (temp.children != null) {

			for (Node node : temp.children) {

				if (node != null) {
					sb.append(node.data);
					preOrderTraersal(node, sb);
					sb.deleteCharAt(sb.length() - 1);
				}
			}
		}
	}

	public static boolean search(String key) {

		Node tempNode = node;

		for (int i = 0; i < key.length(); i++) {

			int index = key.charAt(i) - 'a';

			if (tempNode.children[index].data != key.charAt(i)) {
				return false;
			}

			tempNode = tempNode.children[index];
		}

		return true;

	}

	public static void main(String[] args) {

		String keys[] = { "abc","abced","prateek", "kumar", "kumer" };

		node = new Node(' ');

		for (int i = 0; i <= keys.length - 1; i++) {
			insert(keys[i]);
		}

		// System.out.println(search("kum"));

		StringBuilder sb = new StringBuilder();

		preOrderTraersal(node, sb);
	}

}
