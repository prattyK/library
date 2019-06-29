package sorting;

public class MaxHeap {

	public void buildMaxHeap(int[] arr) {
		for (int i = arr.length/2 - 1; i >= 0; i--) {
			maxHeapify(arr, arr.length , i);
		}
	}

	public void maxHeapify(int[] arr, int n ,int i) {
		int left = left(i);
		int right = right(i);
		int largest=i;
		if (left <= n-1 && arr[left] > arr[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right <= n-1 && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxHeapify(arr, n, largest);
		}
	}

	private int left(int i) {
		return (2 * i + 1);
	}

	private int right(int i) {
		return (2 * i + 2);
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

//	static int[] arr = {2,8,7,1,6,5,3,4};
//	public static void main(String[] args) {
//		new MaxHeap().buildMaxHeap(arr);
//		System.out.println(arr);
//
//	}

}
