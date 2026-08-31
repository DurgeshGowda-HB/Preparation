package questions.arrays;
import java.util.*;
public class remove_duplicate {
    public static void main(String[] args) {
        
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};
        usingset(arr);

    }

    static int remove(int[] arr) {
		//only if array is sorted
		int slow = 0; 
		
		for(int fast=1; fast<arr.length; fast++) {
			
			if(arr[fast] != arr[slow]) {
				slow ++;
				arr[slow] = arr[fast];
			}
		}
		
		return slow + 1; //return the index of unique value print till there
		
	}

    static void removedup(int[] arr) { //unsorted and manual
		
		int k =0; 
		
		for(int i=0; i<arr.length; i++) { // i → current element (full array loop) outer loop
			
			boolean seen = false;
			
			for(int j=0; j<k ; j++) { //j → checking only previous unique elements inner loop
				if(arr[i] == arr[j]) {
					seen =true;
					break;
				}
				
			}
			
			if(!seen) {
				arr[k] = arr[i]; // if not seen then add to front side of array
				k++;
			}
			
		}
		
		for(int i=0; i<k; i++) {
			System.out.println(arr[i]);
		}
	}


    static void usingset(int[] arr) { // using set and take extra space
		
		Set<Integer> s=new  HashSet<Integer>();
		
		for(int num : arr) {
			s.add(num);
		}
		
		System.out.println(s);
		
	}

//		Depends on constraints:
//
//		Sorted → two pointer
//		Unsorted + space → HashSet
//		Unsorted + no space → O(n²) manual

}
