package arrays;

public class MultipleMissing {

	private void multipleMissing(int arr[]) {
		int copyArr[] = new int[arr.length];

		for(int i : arr) {
			copyArr[i] = 1;
		}

		for (int i = 1; i < copyArr.length; i++) {
			if (copyArr[i] == 0) {
				System.out.println("Missing Numbers" + i);
			}
		}

	}

	public static void main(String[] args) {
		int[] missing = { 1, 3, 7 };
		new MultipleMissing().multipleMissing(missing);
	}
}
