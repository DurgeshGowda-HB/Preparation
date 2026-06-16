package questions.others;
import java.util.Scanner;
public class arrticket {
    
    public static void main (String[ ]args ){
    Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the size = ");
		int size=sc.nextInt();
		
		int[] arr=new int[size];
		
		for(int i=0; i<arr.length; i++) {
         System.out.println("Enter the value for " + i);
			arr[i]=sc.nextInt();
		}
		
		arraytic(arr);

    sc.close();
	}
	
	static void arraytic(int[] arr) {
		
		int sum=0;
		int count = 0 ;
		for(int i=0; i<arr.length; i++) {
			if ( i % 2 ==1) {
				sum +=arr[i];
				count++;
			}
		}
		
		System.out.println("total = " + sum);
		System.out.println("coutn = " + count);
		System.out.println("Average is = " + sum/count);
	}

}
