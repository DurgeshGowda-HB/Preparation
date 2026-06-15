package questions.others;
import java.util.Scanner;
public class remove_dup {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
		int size = sc.nextInt();
		
		int[] array=new int[size];
		
		for(int i=0; i<array.length; i++) {
			array[i]=sc.nextInt();
		}
		
		remodup(array);
        sc.close();
	}
	
	static void remodup(int[] arr) {
        int[] newarr = new int[arr.length];
        int count = 0;

        for(int i = 0; i < arr.length; i++) {
            boolean found = false;

            for(int j = 0; j < count; j++) {
                if(arr[i] == newarr[j]) {
                    found = true;
                    break;
                }
            }

            if(found == false) {
                newarr[count] = arr[i];
                count++;
            }
        }
        for(int i = 0; i < count; i++) {
            System.out.print(newarr[i] + " ");
        }
	}
}
