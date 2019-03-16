package com.elementryds;

import java.util.HashMap;
import java.util.Map;

public class DisjointSetImpl {

	private static Map<Long, Node> input = new HashMap<>();

	static class Node {

		int rank;
		Node parent;
		long data;

	}

	public static void makeSet(long val) {

		Node node = new Node();
		node.data = val;
		node.parent = node;
		node.rank = 0;

		input.put(val, node);

	}

	public static long findSet(long data) {
		return findSet(input.get(data)).data;
	}

	/**
	 * Find the representative recursively and does path compression as well.
	 */
	public static Node findSet(Node node) {

		Node parent = node.parent;

		if (parent == node) {
			return node;
		}

		node.parent = findSet(node.parent);

		return node.parent;
	}

	public static boolean union(long data1, long data2) {

		Node firstSet = input.get(data1);

		Node secondSet = input.get(data2);

		Node parent1 = findSet(firstSet);
		Node parent2 = findSet(secondSet);

		if (parent1.data == parent2.data) {

			return false;
		}

		if (parent1.rank >= parent2.rank) {

			parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;

			parent2.parent = parent1;

		} else {

			parent1.parent = parent2;
		}

		return true;

	}

	public static void main(String[] args) {

		makeSet(1);
		makeSet(2);
		makeSet(3);
		makeSet(4);
		makeSet(5);

		union(1, 2);
		union(3, 4);
		union(4, 5);
		union(1, 5);
		
		System.out.println(findSet(1));
		System.out.println(findSet(5));
	}

}
