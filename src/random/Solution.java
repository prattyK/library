package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Solution {

	static TreeNode root = null;

	public String[] findOcurrences(String text, String first, String second) {

//		    List<String> finalList = new ArrayList<>();

		String merge = first + " " + second;

		String result[] = text.split(merge);

		String finalList[] = new String[result.length - 1];
		int j = 0;
		for (int i = 1; i <= result.length - 1; i++) {

			if (result[i].equalsIgnoreCase(" ")) {
				finalList[j] = first;
				j++;
				continue;
			}

			finalList[j] = result[i].split(" ")[1];
			j++;

		}

		return finalList;

	}

	public static void main(String[] args) {

//		root = new TreeNode(4);
//		root.left = new TreeNode(10);
//		root.right = new TreeNode(5);
////		root.left.left = new TreeNode(3);
////		root.left.right = new TreeNode(-99);
//		root.right.left = new TreeNode(4);
////		root.right.right = new TreeNode(7);
////		root.left.left.left = new TreeNode(8);
////		root.left.left.right = new TreeNode(9);
////		root.left.right.left = new TreeNode(-99);
////		root.left.right.right = new TreeNode(-99);
////		root.right.left.left = new TreeNode(12);
////		root.right.left.right = new TreeNode(13);
////		root.right.right.left = new TreeNode(-99);
////		root.right.right.right = new TreeNode(14);

		System.out
				.println(new Solution().findOcurrences("cgfrhjgfj we will we will rock you a klo we will prateek", "we", "will"));
	}
}