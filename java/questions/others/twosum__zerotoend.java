package questions.others;
import java.util.Arrays;

public class twosum__zerotoend {
	public static void main(String[] args) {
		//to push all zero to end
		int[] arr= {0, 2, 7, 1, 0, 0, 3,};
		pushzerotoend(arr);
		
		//for two sum
		int[] arrr= {1, 2, 5, 8, 3};
		int target= 13;
		int[] ans=twosum(arrr, target);
		System.out.println(Arrays.toString(ans));
		
	}
	
	static int[] twosum(int arr[], int target) {
		
		if(arr.length<2) {
			System.out.println("Array should contain atleast two elements");
			return new int[] {};
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++){
				if(arr[i] + arr[j]==target) {
					return new int[] { arr[i],arr[j] };
				}
			}
		}
		
		return new int[] {};
		
	}
	
	static void pushzerotoend(int[] arr) {
		
		int j=0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				j++;
			}
		}
		
		for(int num : arr) {
			System.out.print(num);
		}
		
	}
	
}