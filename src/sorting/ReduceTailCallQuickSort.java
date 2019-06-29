package sorting;

public class ReduceTailCallQuickSort {

	private void reduceTailCallQuickSort(int arr[], int p, int r) {
		while (p < r) {
			int q = partition(arr, p, r);
			if (q - p < r - q) {
				reduceTailCallQuickSort(arr, p, q - 1);
				p = q + 1;
			
			} else {
				reduceTailCallQuickSort(arr, q + 1, r);
				r = q - 1;
			}
		}
	}

	private int partition(int arr[], int p, int r) {
		int x = arr[r];
		int i = p - 1;

		for (int j = p; j <= r - 1; j++) {
			if (arr[j] <= x) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[r];
		arr[r] = temp;
		return i+1;
	}

	private static int[] arr = { 2, 8, 7, 1, 6, 5, 3, 4 };

	public static void main(String[] args) {

		ReduceTailCallQuickSort reduce = new ReduceTailCallQuickSort();
		reduce.reduceTailCallQuickSort(arr, 0, arr.length - 1);
		System.out.println(arr);
	}

}
