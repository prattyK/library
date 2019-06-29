package stringmanipulation;

public class DistinctChars {

	public void printDistinct(String str) {

		int count[] = new int[256];

		for (int i = 0; i <= str.length() - 1; i++) {

			if (str.charAt(i) != ' ') {

				count[(int) str.charAt(i)]++;

			}
		}

		for (int i = 0; i <= str.length()-1; i++) {

			if (count[(int) str.charAt(i)] == 1) {
				System.out.println(str.charAt(i));
			}

		}

	}

	public static void main(String[] args) {

		DistinctChars distinctChars = new DistinctChars();
		distinctChars.printDistinct("GeeksforGeeks");

	}

}
