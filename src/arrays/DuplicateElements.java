package arrays;

import java.util.Arrays;

public class DuplicateElements {

	private int findDuplicateElements(int[] arr) {

		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] == arr[i+1]) {
				return arr[i];
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] t = { 1, 2, 3, 4, 5, 6, 6, 0 };
		System.out.println(new DuplicateElements().findDuplicateElements(t));

	}

}
