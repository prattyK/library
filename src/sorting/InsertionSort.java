package sorting;

public class InsertionSort {

	private static int arr[] = { 5, 8, 6, 2, 1 };

	public void sort(int arr[]) {
		
	

		if (arr != null && arr.length > 0) {

			for (int j = 1; j <= arr.length - 1; j++) {

				int i = j - 1;

				int key = arr[j];

				while (i > 0 && arr[i] > key) {

					arr[i + 1] = arr[i];

					i--;

				}

				arr[i + 1] = key;

			}

		}

	}

	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort(arr);
	}

}
