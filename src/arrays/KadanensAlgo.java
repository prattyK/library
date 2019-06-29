package arrays;

import java.util.Arrays;

public class KadanensAlgo {

	private int[] processMaxSumSubArray(int a[]) {

		int maxSoFar = a[0];
		int maxEnding = 0;
		int start = -1;
		int s = -1;
		int end = -1;

		for (int i = 0; i <= a.length - 1; i++) {

			maxEnding = maxEnding + a[i];

			if (maxSoFar < maxEnding) {
				maxSoFar = maxEnding;
				start = s;
				end = i;
			}

			if (maxEnding < 0) {
				maxEnding = 0;
				s = i + 1;
			}
		}

		return Arrays.copyOfRange(a, start, end + 1);
	}

	public static void main(String[] args) {

		int input[] = { 4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, -3, 3, 1, 2 };
		new KadanensAlgo().processMaxSumSubArray(input);

	}

}
