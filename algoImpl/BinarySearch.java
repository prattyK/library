package algoImpl;

public class BinarySearch {

	
	public static int search(int arr[] , int start , int length, int src) {
		
		int mid = (start + length -1)/2; 
		
		if(arr[mid] == src) {
			return mid;
		}
		
		if(start == length) {
			if(arr[mid] == src) {
				return mid;
			} else {
				return -1;
			}
			
		}
		
		if(arr[mid] > src) {
			
			return search(arr , 0 , mid, src);
		}
		
        if(arr[mid] < src) {
        	return search(arr , mid+1 , length , src);
		}
		
        return -1;
		
	}
	
	
	
	public static void main(String[] args) {

		int arr[] = {2,3,4,10,40};
		
		int result = search(arr,0 ,arr.length,10);
		
		
		System.out.println(result);
		
	}

}
