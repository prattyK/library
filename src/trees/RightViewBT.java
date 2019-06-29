package trees;

public class RightViewBT {

	static class Node {
		int data;
		Node left, right = null;

		public Node(int data) {
			this.data = data;
		}
	}

	public void printReightView() {

	}

	public int height(Node temp) {
		if (temp == null) {
			return 0;
		}
		return 1 + Math.max(height(temp.left), height(temp.right));
	}

	public static void main(String[] args) {

	}

}
