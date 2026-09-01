package questions.arrays.hashing;
import java.util.Arrays;
public class sort_color {

    public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {2,0,2,1,1,0};
		int[] ans = sort(arr);
		System.out.println(Arrays.toString(ans));
		
	}
	static int[] sort(int[] arr) {

		// time - O(N)
		// space = O(1)
		
		int lo= 0;
		int mid =0;
		int hi = arr.length -1;
		
		  // process elements until mid crosses hi
	    while(mid <= hi) {

	        if(arr[mid] == 0) {
	            // case 0  move to left side
	            swap(arr, mid, lo);

	            lo++;   // next 0 position
	            mid++;  // move forward
	        } 
	        else if(arr[mid] == 1) {
	            // case 1  already in correct position
	            mid++;  // just move forward
	        } 
	        else { // arr[mid] == 2
	            // case 2  move to right side
	            swap(arr, mid, hi);

	            hi--;   // reduce right boundary

	            // IMPORTANT:
	            // do NOT increment mid here
	            // because swapped element at mid is unknown
	        }
	       
	    }
	    return arr;
	}

	
	static void swap(int[] arr, int n, int m) {
		int temp = arr[n];
		arr[n] = arr[m];
		arr[m] = temp;
	}
    
}
