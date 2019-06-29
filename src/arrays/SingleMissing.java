package arrays;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleMissing {

	
	ExecutorService ex = Executors.newFixedThreadPool(10);
	
	private int multipleMissing(int arr[]) {

//		Arrays.sort(arr);

		int sum = arr.length * (arr.length+1) / 2;
		
		
		for(int i : arr) {
			sum-=i;
		}

		return sum;

	}

	public static void main(String[] args) {
		int[] missing = { 3,0,1,2,5 };
		System.out.println(new SingleMissing().multipleMissing(missing));
	}
}
