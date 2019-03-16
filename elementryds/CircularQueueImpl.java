package com.elementryds;

public class CircularQueueImpl {

	int front = -1;
	int rear = -1;

	int queueArray[] = new int[10];

	public void addElementInQueue(int x) {

		if ((rear == queueArray.length - 1 && front == 0) || rear == front - 1) {
			System.out.println("-----Overflow-----");
			return;
		}

		if (front == -1) {
			front++;
		}

		rear++;
		queueArray[rear] = x;

	}

	public void popElementFromQueue() {

		if (front == rear) {
			front = -1;
			rear = -1;
			return;
		}

		if (front == queueArray.length - 1) {
			front = 0;
			return;
		}

		front++;
	}

	public void printQueue() {

		if (front != -1) {
			for (int i = front; i <= rear; i++) {

				System.out.println(queueArray[i]);
			}
		} else {
			System.out.println("Queue is empty");
		}
	}

	public static void main(String[] args) {

		CircularQueueImpl circularQueueImpl = new CircularQueueImpl();
		circularQueueImpl.addElementInQueue(1);
		circularQueueImpl.addElementInQueue(2);
		circularQueueImpl.addElementInQueue(3);
		circularQueueImpl.addElementInQueue(4);

		circularQueueImpl.printQueue();

		System.out.println("------Added Element -----------");

		circularQueueImpl.popElementFromQueue();
		circularQueueImpl.popElementFromQueue();
		circularQueueImpl.popElementFromQueue();
		circularQueueImpl.popElementFromQueue();

		circularQueueImpl.printQueue();
	}

}
