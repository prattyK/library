package sorting;

import java.util.Random;

public class RandomizedQuickSort {

	private Random random = new Random();

	private int randomizedPartition(int[] arr, int p, int r) {
		int temp = p + random.nextInt(r - p);
		int temp1 = arr[r];
		arr[r] = arr[temp];
		arr[temp] = temp1;

		return partition(arr, p, r);
	}

	private int partition(int[] arr, int p, int r) {
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
		return i + 1;
	}

	private void randomizedQuickSort(int[] arr, int p, int r) {

		while (p < r) {
			int q = randomizedPartition(arr, p, r);
			if (q - p < r - q) {
				randomizedQuickSort(arr, p, q - 1);
				p = q + 1;
			} else {
				randomizedQuickSort(arr, q + 1, r);
				r = q - 1;
			}
		}

	}

	static int[] arr = { 2, 8, 7, 1, 6, 5, 3, 4 };

	public static void main(String[] args) {

		RandomizedQuickSort random = new RandomizedQuickSort();
		random.randomizedQuickSort(arr, 0, arr.length - 1);

		System.out.println(arr);

	}

}
