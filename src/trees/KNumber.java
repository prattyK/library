package trees;

public class KNumber {
  	public static int kthGrammar(int N, int K) {

		String result = "";

		if (N == 0) {
			return 0;
		}

		if (N <= 2 && N > 0) {
			result = buildPattern("", Math.pow(2, N - 1));
		} else {
			result = buildPattern("", Math.pow(2, N - 1) / 2);
		}

		return Integer.valueOf(result.split("")[K - 1]);
	}

	static int index = 0;

	private static String buildPattern(String pattern, double N) {

		if (N == 0) {
			return pattern;
		}
		int temp = 0;

		if (pattern.equalsIgnoreCase("")) {
			temp = 0;
		} else {
			String[] split = pattern.split("");
			temp = Integer.valueOf(split[++index]);
		}

		if (temp == 0 || temp == -1) {
			pattern = pattern.concat("01");
		} else {
			pattern = pattern.concat("10");
		}
		return buildPattern(pattern, (N - 1));
	}
	
	public static void main(String[] args) {
		System.out.println(kthGrammar(2, 2));
	}

}