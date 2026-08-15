package searching.binary;

public class find_min_in_rotated_sorted_array {
    public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {3,4,5,1,2};
		System.out.println(mim(arr));
		
	}
	
	static int mim(int[] arr) {
		
		int start = 0 ;
		int end = arr.length-1;
		
		while(start<end) {
			
			int mid = start + (end - start)/2;
			
			if(arr[mid] > arr[end]) {
				start = mid + 1;
			}else {
				end = mid;
			}
			
		}
		return arr[start];
	}

}
