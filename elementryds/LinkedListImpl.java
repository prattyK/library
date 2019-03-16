package com.elementryds;

public class LinkedListImpl {

	Node root;

	static class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

	}

	public void add(int data) {
		//
		Node newNode = new Node(data);
		newNode.next = root;

		root = newNode;
	}

	public void deleteByKey(int data) {

		Node temp = root;

		Node previous = null;
		while (temp.next != null) {

			if (temp.data == data) {
				previous.next = temp.next;
				temp.next = null;
				temp = previous;
				break;
			}

			previous = temp;
			temp = temp.next;
		}

	}

	public void delete() {

		Node temp = root;

		root = temp.next;
	}

	public void printLinkedList() {

		Node temp = root;

		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {

		LinkedListImpl linkedListImpl = new LinkedListImpl();
		linkedListImpl.add(1);
		linkedListImpl.add(2);
		linkedListImpl.add(3);
		linkedListImpl.add(4);
		linkedListImpl.add(5);
		linkedListImpl.printLinkedList();
		System.out.println("--------------D key-----------");
		linkedListImpl.deleteByKey(3);
		System.out.println("--------------key-----------");
		linkedListImpl.delete();
		linkedListImpl.printLinkedList();
	}
}
