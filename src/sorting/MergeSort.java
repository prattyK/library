package sorting;

public class MergeSort {

	private void merge(int arr[], int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;

		int L[] = new int[n1 + 1];
		int R[] = new int[n2 + 1];

		for (int i = 0; i <= n1 - 1; i++) {
			L[i] = arr[p + i];
		}

		for (int j = 0; j <= n2 - 1; j++) {
			R[j] = arr[q + j + 1];
		}

		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;
//		int k = p;

		for (int k = p; k <= r; k++) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i = i + 1;
			} else {
				arr[k] = R[j];
				j = j + 1;
			}
		}		
	}

	private void mergeSort(int arr[], int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(arr, p, q);
			mergeSort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
		System.out.println(arr);
	}

	static int arr[] = {5,8,6,2,1};
	
	public static void main(String[] args) {
		MergeSort mg = new MergeSort();
		mg.mergeSort(arr, 0, arr.length - 1);
		System.out.println(arr);
	}

}
