package com.elementryds;

/** Class BinaryHeap **/
public class BinaryHeapImpl    
{

	// private static int capacity;
	private static int heapSize;
	private static int heapArr[] = new int[12];

	public static int parent(int i) {

		return (i - 1) / 2;
	}

	public static int left(int i) {

		return (2 * i + 1);

	}

	public static int right(int i) {

		return (2 * i + 2);

	}

	public static void insertKey(int key) {

		if (heapArr.length - 1 <= heapSize) {
			return;
		}

		heapSize++;

		int i = heapSize - 1;

		heapArr[i] = key;

		while (heapSize != 0 && heapArr[parent(i)] > heapArr[i]) {

			int parent = heapArr[parent(i)];

			heapArr[parent(i)] = heapArr[i];

			heapArr[i] = parent;

			i = parent(i);

		}

	}

	public static void decreaseKey(int i, int new_Val) {

		if (i > -1) {

			heapArr[i] = new_Val;

			while (i != 0 && heapArr[i] < heapArr[parent(i)]) {

				int parent = heapArr[parent(i)];

				heapArr[parent(i)] = heapArr[i];

				heapArr[i] = parent;

				i = parent(i);

			}

		}

	}

	public static int extractMin() {

		if (heapSize <= -1) {
			return Integer.MAX_VALUE;
		}

		if (heapSize == 1) {
			heapSize--;
			return heapArr[0];
		}

		int root = heapArr[0];
		heapArr[0] = heapArr[heapSize - 1];
		heapSize--;
		minHeapify(0);
		return root;
	}

	public static void deleteKey(int i) {

		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}

	public static void minHeapify(int i) {

		int l = left(i);
		int r = right(i);

		int smallest = i;

		if (l < heapSize && heapArr[l] < heapArr[i]) {
			smallest = l;
		}
		if (r < heapSize && heapArr[r] < heapArr[smallest]) {
			smallest = r;
		}

		if (smallest != i) {

			int parent = heapArr[i];

			heapArr[i] = heapArr[smallest];

			heapArr[smallest] = parent;

			minHeapify(smallest);
		}
	}

	public static void main(String[] args) {

		insertKey(10);
		insertKey(2);
		insertKey(3);
		insertKey(4);
		insertKey(5);
		insertKey(6);
		insertKey(7);
		insertKey(8);
		insertKey(9);

		System.out.println(extractMin());

		System.out.println(heapArr);

		System.out.println(extractMin());
	}
}
