package trees;

public class PreOrderTraversal {

	static Node root;
	
	public void preOrder(Node root) {
		
		
		if(root == null ) {
			return;
		}
		
//		if(root !=null && root.getLeft() != null && root.getRight() != null) {
		System.out.println(root.getVal());
		preOrder(root.getLeft());
		preOrder(root.getRight());
//		}
	}
	
	
	
	
	public static void main(String[] args) {

		root = BST.insert(root, new Node(1));
		root = BST.insert(root, new Node(2));
		root = BST.insert(root, new Node(4));
		root = BST.insert(root, new Node(5));
		root = BST.insert(root, new Node(3));
//		root = BST.insert(root, new Node(-1));
//		root = BST.insert(root, new Node(10));
		
		new PreOrderTraversal().preOrder(root);
	}

}
