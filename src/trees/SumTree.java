package trees;

public class SumTree {

	static Node root;

	static class Node {
		int data;
		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	public static int convertSumTree(Node temp) {

		if (temp == null) {
			return 0;
		}
		int old = temp.data;
		temp.data = convertSumTree(temp.left) +  convertSumTree(temp.right);
		return temp.data + old;
	}

	public static void preOrder(Node temp) {

		if(temp == null) {
			return ;
		}
		
		System.out.println(temp.data);
		preOrder(temp.left);
		preOrder(temp.right);
	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
//		root.left.left.left = new Node(8);
//		root.left.left.right = new Node(9);
//		root.left.right.left = new Node(10);
//		root.left.right.right = new Node(11);
//		root.right.left.left = new Node(12);
//		root.right.left.right = new Node(13);
//		root.right.right.left = new Node(14);
//		root.right.right.right = new Node(15);
//		Node temp = root;
//		System.out.println(convertSumTree(temp);
		convertSumTree(root);
		preOrder(root);

	}

}
