package trees;

public class CheckBT {

	static Node root;

	static boolean[] result = null;

	static class Node {
		int data;
		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	public static int height(Node temp) {

		if (temp == null) {
			return 0;
		}

		return 1 + Math.max(height(temp.left), height(temp.right));
	}

	public static void inorder(Node temp, int i) {
		
		if(temp == null) {
			return;
		}

		inorder(temp.left, 2 * i + 1);

		result[i] = true;

		inorder(temp.right, 2 * i + 2);

	}

	
	
	
	
	public static boolean checkBT() {

		Node temp = root;

		int h = height(temp);

		result = new boolean[(int) (Math.pow(2, h) - 1)];

		Node temp1 = root;
		inorder(temp1, 0);
		
		for(boolean r : result) {
			if(!r) {
				return r;
			}
		}
		
		return true;
		
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
		System.out.println(checkBT());
	}

}
