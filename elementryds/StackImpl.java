package com.elementryds;

public class StackImpl {

	private int stackArray[] = new int[3];
	private int top = 0;

	public void push(int data) {

		if (top > stackArray.length - 1) {
			throw new ArrayIndexOutOfBoundsException();
		}

		stackArray[top] = data;
		top++;

	}

	public int pop() {

		if (top < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}

		top = top - 1;

		return stackArray[top];

	}

	public void printStack() {

		for (int i : stackArray) {
			System.out.println(i);

		}
	}

	public static void main(String[] args) {

		StackImpl stackImpl = new StackImpl();
		stackImpl.push(2);
		stackImpl.push(3);
		stackImpl.printStack();
		System.out.println(stackImpl.pop());
		System.out.println(stackImpl.pop());
	}

}
