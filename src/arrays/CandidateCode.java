package arrays;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CandidateCode {

	private int first;
	private int second;
	private int latestSum;
	private int highest;
	private int lowerHighest;

	List<Integer> inputDs;

	private String processArrays(int arr1[]) {

	
		mergeSort(arr1, 0, arr1.length - 1);

		first = arr1[arr1.length - 1];
		second = arr1[arr1.length - 2];
		highest = inputDs.indexOf(first);
		lowerHighest = inputDs.indexOf(second);

		
		if (highest - lowerHighest > 1) {

			return String.valueOf(arr1[highest]).concat(String.valueOf(arr1[lowerHighest]));

		} else {

			for (int i = arr1.length - 3; i >= 0; i--) {


					int tempVar = arr1[i];

					int temp = inputDs.indexOf(tempVar);

					int diff = Math.abs(highest - temp);

					if (diff > 1) {
						int tempSum = first + tempVar;

						if (latestSum > 0) {
							if (latestSum < tempSum) {
								latestSum = tempSum;
								second = arr1[i];
							}

						} else {
							latestSum = tempSum;
							second = arr1[i];
						}

				}

			}

			if(arr1.length == 2) {
				latestSum = first+second;
			}
			
			highest = inputDs.indexOf(first);
			lowerHighest = inputDs.indexOf(second);

			if (highest == lowerHighest) {

				for (int i = 0; i <= inputDs.size() - 1; i++) {

					if(i == highest) {
						continue;
					}
					
					if(inputDs.get(i) == second) {
						lowerHighest =i;
					}
					
				}

			}

		}

		return "";

	}

	private String invokeInitial(int[] arr1) {
		inputDs = new ArrayList<>();
		for (int i = 0; i <= arr1.length - 1; i++) {
			inputDs.add(arr1[i]);
		}
		String s = processArrays(arr1);

		if (!s.equalsIgnoreCase("")) {
			return s;
		} else {

			Map<String, Integer> resultList = new HashMap<>();

			resultList.put("first", first);
			resultList.put("second", second);
			resultList.put("highest", highest);
			resultList.put("lowerHighest", lowerHighest);
			resultList.put("latestSum", latestSum);

			latestSum = 0;


			List<Integer> temp1 = new ArrayList<>();
			
			for (int i = 0; i <= inputDs.size() - 1; i++) {

				if (inputDs.get(i) == first || inputDs.get(i) == second) {
					continue;
				}
				temp1.add(inputDs.get(i));

			}
			int tempList[] = new int[temp1.size()];
			
			for (int i = 0; i <=temp1.size() - 1; i++) {

				tempList[i] = temp1.get(i);

			}

			processArrays(tempList);

			
			if (latestSum == resultList.get("latestSum")) {

				
				
				if (resultList.get("second") > 0 && first > 0 && second > resultList.get("second")) {
					resultList.put("first", first);
					resultList.put("second", second);
				}
//				if (second > 0 && second < resultList.get("second")) {
//					resultList.put("first", first);
//					resultList.put("second", second);
//				}

			}

			StringBuilder str = new StringBuilder();

			if (resultList.get("second") > 0) {
				str.append(resultList.get("second"));
			}

			if (resultList.get("first") > 0) {
				str.append(resultList.get("first"));
			}
			return str.toString();
		}
	}

	private void merge(int arr[], int p, int q, int r) {

		int n1 = q - p + 1;
		int n2 = r - q;

		int L[] = new int[n1 + 1];
		int R[] = new int[n2 + 1];

		for (int i = 0; i <= n1 - 1; i++) {
			L[i] = arr[p + i];

		}

		for (int i = 0; i <= n2 - 1; i++) {
			R[i] = arr[q + i + 1];
		}

		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		int k = 0;
		int j = 0;

		for (int i = p; i <= r; i++) {

			if (L[k] <= R[j]) {
				arr[i] = L[k];
				k++;
			} else {

				arr[i] = R[j];
				j++;

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

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {

			int inputLength = scanner.nextInt();

			int arr1[] = new int[inputLength];
//			int arr2[] = new int[inputLength];

			for (int i = 0; i <= inputLength - 1; i++) {
				arr1[i] = scanner.nextInt();
			}

//			for (int i = 0; i <= inputLength - 1; i++) {
//				arr2[i] = scanner.nextInt();
//			}

			String result = new CandidateCode().invokeInitial(arr1);

			System.out.println(result);

		}

		scanner.close();
	}
}
