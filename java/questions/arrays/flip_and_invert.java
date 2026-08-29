package questions.arrays;
import java.util.Arrays;
public class flip_and_invert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = {
				{1, 0, 0},
				{1, 1, 0}
		};
		
		flip_invert(arr);
		
		//for printing or displaying
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	static int[][] flip_invert(int[][] arr){
		
		for(int i=0; i<arr.length; i++) {
			
			int left = 0;
			int right = arr[i].length - 1;
			
			while(left <= right) {
				
				//swap
				int temp = arr[i][left]^1;
				arr[i][left] = arr[i][right]^1;
				arr[i][right] = temp;
				left ++;
				right --;
				
			}
			
		}
		return arr;
	}

}
