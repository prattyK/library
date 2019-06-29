package trees;

//import for Scanner and other utility classes
import java.util.Scanner;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class MirrorTree {

	static Node root;

	static class Node {

		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	private static Node createTree(int parent, int actual, String side) {


		Node node1 = new Node(actual, null, null);
		
		if(root == null) {
			root = new Node(parent, null, null);
		}
		
		Node temp = root;
		createInternalNodeTree(temp, parent, side, node1);
		return root;
	}
	
	private static Node createInternalNodeTree(Node temp,int data,String side,Node actual) {
		
		if(temp == null) {
			return null;
		}
		
		if(temp!= null && temp.data == data) {
			if (side.equalsIgnoreCase("L")) {
				temp.left = actual;
			} else {
				temp.right = actual;
			}
			return root;
		} 
	    createInternalNodeTree(temp.left, data, side, actual);
		createInternalNodeTree(temp.right, data, side, actual);
		return root;
	}

	private static int findMirrorNode(int data, Node left, Node right) {

		if (left == null || right == null) {
			return -1;
		}
		
		if(left.data == data) {
//			System.out.println(right.data);
            return right.data;			
		}
		
		if(right.data == data) {
//			System.out.println(left.data);
			return left.data;
		}
		
		int mirrorNode = findMirrorNode(data, left.left, right.right);
		
		if(mirrorNode != -1) {
//			System.out.println(mirrorNode);
			return mirrorNode;
		}
		
        return findMirrorNode(data, left.right, right.left);		

//		return data;

	}

	public static void main(String args[]) throws Exception {
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 */

		// Scanner
		Scanner s = new Scanner(System.in);
		int total = s.nextInt();
		int q = s.nextInt();

		for (int i = 0; i <= total - 2; i++) {
			int t1 = s.nextInt();
//			System.out.println(i+"s.nextInt"+t1);
			root =createTree(t1, s.nextInt(), s.next());
		}

		for (int i = 0; i <= q - 1; i++) {
			int target = s.nextInt();
			if (root == null) {
				System.out.println(-1);
				return;
			}
			System.out.println(findMirrorNode(target, root, root));
		}
		
		s.close();

	}
}
