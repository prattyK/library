package com.elementryds;

public class QueueImpl {

	int tail;
	int head;

	int queueColletion[] = new int[10];

	public void pushElement(int s) {

		if (tail >= queueColletion.length) {

			throw new ArrayIndexOutOfBoundsException();
		}

		queueColletion[tail] = s;
		tail++;

	}

	public int popElement() {

		if (head == tail) {
			throw new ArrayIndexOutOfBoundsException();
		}

		int poppedElement = queueColletion[head];

		head++;

		return poppedElement;
	}

	public void printQueue() {

		for (int i = head; i <= queueColletion.length - 1; i++) {
			System.out.println(queueColletion[i]);
		}

	}

	public static void main(String[] args) {

		QueueImpl queueImpl = new QueueImpl();
		queueImpl.pushElement(2);
		queueImpl.pushElement(3);
		queueImpl.pushElement(4);
		queueImpl.printQueue();
		System.out.println("-------pushed----------------");
		
		queueImpl.popElement();
		queueImpl.popElement();
		System.out.println("-------popped----------------");
		queueImpl.printQueue();
	}

}
