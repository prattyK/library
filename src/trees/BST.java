package trees;

public class BST {

	static Node root;

	public static Node insert(Node t, Node curr) {

		if (t == null) {
			root = curr;
			return root;
		}

		Node y = null;
		Node temp = t;

		while (temp != null) {

			y = temp;

			if (curr.getVal() >= temp.getVal()) {
				temp = temp.getRight();
			} else {
				temp = temp.getLeft();
			}

		}

		if (y.getVal() < curr.getVal()) {
			y.setRight(curr);
		} else {
			y.setLeft(curr);
		}
		return root;

	}

	public Node treeMinimun(Node curr) {
		if (curr != null) {
             while(curr.getLeft() != null) {
            	 curr = curr.getLeft();
             }
			
		}
		return curr;
	}
	
	public Node treeMax(Node curr) {
		if (curr != null) {
             while(curr.getRight() != null) {
            	 curr = curr.getRight();
             }
		}
		return curr;
	}
	
	public void inorder(Node t) {
		
		if(t ==  null) {
			return;
		}
		
		inorder(t.getLeft());
		System.out.println(t.getVal());
		inorder(t.getRight());
		
		
	}
	
//	public Node treeSearch() {
//	
//		
//		
//	}
	

	public static void main(String[] args) {

		insert(root, new Node(1));
		insert(root, new Node(2));
		insert(root, new Node(3));
		insert(root, new Node(4));
		insert(root, new Node(5));
		insert(root, new Node(0));
		insert(root, new Node(10));
		new BST().inorder(root);

	}

}
