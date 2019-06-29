package arrays;

public class ArrayPairs {

	public static int countOccurrencesOf(String str, String sub) {
//		if (!hasLength(str) || !hasLength(sub)) {
//			return 0;
//		}

		int count = 0;
		int pos = 0;
		int idx;
		while ((idx = str.indexOf(sub, pos)) != -1) {
			++count;
			pos = idx + sub.length();
		}
		return count;
	}
	
	public static void main(String[] args) {

		String s = "PrateeKKanujiya";
		
		System.out.println(ArrayPairs.countOccurrencesOf(s, "a"));
		
		
	}

}
