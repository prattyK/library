package arrays;

public class XOR {

	private int missingByXOR(int[] arr, int n) {

		int x1 = arr[0];
		int x2 = 1;

		for (int i = 1; i < n; i++) {
			x1 = x1 ^ arr[i];
		}

		for (int i = 2; i <= n + 1; i++) {
			x2 = x2 ^ i;
		}

		return x1 ^ x2;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 4, 5};
		System.out.println("MIssing Number"+new XOR().missingByXOR(input, input.length));
	}
}
