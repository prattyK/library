package com.elementryds;

public class MinHeap {

	private int heapSize;

	public int left(int i) {

		return (2 * i + 1);

	}

	public int right(int i) {

		return (2 * i + 2);
	}

	public int parent(int i) {

		return (i - 1) / 2;
	}

	public int[] buildMinHeap(int arr[]) {

		if (arr.length > 0) {

			heapSize = arr.length - 1;

			for (int i = arr.length / 2 - 1; i <= 0; i--) {

				minHeapify(arr, i);
			}

		}

		return arr;

	}

	public int extractMin(int arr[]) {

		int min = Integer.MIN_VALUE;

		if (arr.length > 0) {

			min = arr[0];

			arr[0] = arr[heapSize];

			heapSize = heapSize - 1;

			minHeapify(arr, 0);

		}

		return min;
	}

	public int heapMin(int arr[]) {
		return arr[0];
	}

	public int[] minHeapify(int arr[], int i) {

		int l = left(i);

		int r = right(i);

		int min = Integer.MIN_VALUE;

		if (l <= heapSize && arr[l] < arr[i]) {
			min = l;
		} else {
			min = i;
		}

		if (r <= heapSize && arr[r] < arr[min]) {
			min = r;
		}

		if (min != i) {
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			minHeapify(arr, min);
		}

		return arr;
	}

	public static void main(String[] args) {

		
	}

}
