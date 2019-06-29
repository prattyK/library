package LinkedList;

public class MergeTwoSortedList {

	static ListNode l1 = null;
	static ListNode l2 = null;
	static ListNode result = new ListNode(0);

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null) {
			return l1;
		}

		if (l1 != null && l2 == null) {

			return l1;
		}

		if (l2 != null && l1 == null) {

			return l2;
		}

		ListNode result = null;

		if (l1.val < l2.val) {

			result = l1;
			result.next = mergeTwoLists(l1.next, l2);

		} else {
			result = l2;
			result.next = mergeTwoLists(l1, l2.next);
		}

		return result;

	}

	public static void main(String[] args) {

		l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l2 = new ListNode(4);
		l2.next = new ListNode(5);
		l2.next.next = new ListNode(6);
//		ListNode temp = result;
		ListNode result = mergeTwoLists(l1, l2);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

}
