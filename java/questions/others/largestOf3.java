package questions.others;
import java.util.Scanner;
public class largestOf3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Enter the numberb 1 :");
		int a=sc.nextInt();
		System.out.print("Enter the numberb 2:");
		int b=sc.nextInt();
		System.out.print("Enter the numberb 2:");
		int c=sc.nextInt();
		
		if(a>b && a>c) {
			System.out.println("A is largest ");	
		}else if(b>a && b>c) {
			System.out.println(" B is largest ");
		}else {
			System.out.println("C is the larges t  ");
		}
	sc.close();
    }
    
}
