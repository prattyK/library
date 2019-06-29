package LinkedList;

public class ReverseLinkedList {

	static Node head = null;

	static class Node {

		int val;
		Node next = null;

		public Node(int val) {
			this.val = val;
		}
	}

	public static Node reverse(Node head,String h) {

		Node prev = null;
		Node curr = head;

		while (curr != null) {

			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	
	public static Node reverse(Node head) {
		
		if(head == null || head.next ==null) {
			return head;
		}
		
		Node reverse = reverse(head.next);
		
		head.next.next = head;
		head.next = null;
		return reverse;
		
	}
	
	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		Node head1 = reverse(head);

		while (head1 != null) {
			System.out.println(head1.val);
			head1 = head1.next;
		}
	}

}
