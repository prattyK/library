package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	static Node root;

	public static void levelOrder(Node root) {

		Node temp = root;
		Queue<Node> result = new LinkedList<>();
		if (temp != null) {
			result.add(temp);
		}
		
		
		while(!result.isEmpty()) {
			Node p = result.poll();
			System.out.println(result.poll());
			
			if(p.getLeft()!= null) {
				result.add(p.getLeft());
			}
			
			if(p.getRight()!= null) {
				result.add(p.getRight());
			}
			
		}
	}

	public static void main(String[] args) {
		root = BST.insert(root, new Node(3));
		root = BST.insert(root, new Node(1));
		root = BST.insert(root, new Node(7));
		root = BST.insert(root, new Node(5));
		root = BST.insert(root, new Node(4));
		levelOrder(root);
	}

}
