package trees;

public class PostOrderTraversal {
	
	static Node root;
	
	public void postOrder(Node root) {
		
		if(root == null) {
			return ;
		}
		
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.println(root.getVal());
	}
	
	
	
	
	public static void main(String[] args) {
		root = BST.insert(root, new Node(1));
		root = BST.insert(root, new Node(2));
		root = BST.insert(root, new Node(4));
		root = BST.insert(root, new Node(5));
		root = BST.insert(root, new Node(3));
		
		new PostOrderTraversal().postOrder(root);
	}

}
