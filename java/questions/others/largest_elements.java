package questions.others;

public class largest_elements {

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = { 10, 40 ,30 ,20 ,10};
		largest(arr);
		largest2(arr);
		
	}
	
	static void largest(int[] arr) {
		// this is for second largest
		int largest = 0;
		int second_largest = 0;
		
		for(int num : arr) {
			if(num > largest) {
				second_largest = largest;
				largest = num;
			}else if(num > second_largest && num != largest) {
				second_largest = num;
			}
		}
		
		System.out.println("largest = " + largest);
		System.out.println("second largest = " + second_largest);
		
	}
	
	
	static void largest2(int[] arr) {
		// third largest element
		int first = 0;
		int second = 0;
		int third = 0;
		
		for(int num : arr) {
			
			if(num > first) {
				third = second;
				second = first;
				first = num;
			}
			else if(num > second && num != first) {
				third = second;
				second = num;
			}
			else if(num > third && num != first && num != second) {
				num = third;
			}
		}
		
		System.out.println("first largest = " + first);
		System.out.println("second largest = " + second);
		System.out.println("Thirs largest = " + third);
		
	}
    
}
