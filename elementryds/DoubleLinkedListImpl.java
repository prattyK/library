package com.elementryds;

public class DoubleLinkedListImpl {

	Node root;

	static class Node {
		int data;
		Node prev;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void pushElement(int data) {

		Node temp = root;

		Node newNode = new Node(data);
		newNode.next = temp;

		if (temp != null) {
			temp.prev = newNode;
		}

		root = newNode;

	}

	public void popElement() {

		if (root.next == null) {
			System.out.println("Underflow List");
			return;
		}

		Node temp = root;

		Node nextNode = temp.next;

		temp.next = null;

		nextNode.prev = null;

		root = nextNode;

	}

	// TODO : Need to repair for first and Last node
	public void popElementByKey(int key) {

		if (root.next == null) {
			System.out.println("Underflow List");
			return;
		}

		Node temp = root;

		while (temp != null) {
			
			if (temp.data == key) {
				
				Node previous = temp.prev;
				previous.next = temp.next;
				previous = temp.next.prev;
				temp.prev = null;
				temp.next = null;
				root = previous;
				break;
			}

			temp = temp.next;

		}

	}

	public void printDoubleLinkedList() {
		Node temp = root;

		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

	}

	public static void main(String[] args) {

		DoubleLinkedListImpl doubleLinkedList = new DoubleLinkedListImpl();
		doubleLinkedList.pushElement(1);
		doubleLinkedList.pushElement(2);
		doubleLinkedList.pushElement(3);
		doubleLinkedList.pushElement(4);

		System.out.println("----------Push Element------------");

		doubleLinkedList.printDoubleLinkedList();

		doubleLinkedList.popElement();
		doubleLinkedList.popElement();

		System.out.println("------POPped Element---------");

		doubleLinkedList.printDoubleLinkedList();

//		doubleLinkedList.popElementByKey(1);

		System.out.println("------POPped Element By Key---------");

		doubleLinkedList.printDoubleLinkedList();
	}

}
