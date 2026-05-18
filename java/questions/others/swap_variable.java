package questions.others;

public class swap_variable {
    public static void main(String[] args) {
        // Method 1: Using a Temporary Variable
       { int a = 5, b = 10, temp;
        temp = a; // temp is 5
        a = b;    // a is 10
        b = temp; // b is 5
       }


        //Method 2: Using Arithmetic (Without Temporary Variable)
        {
            int a = 5, b = 10;
            a = a + b; // a = 15
            b = a - b; // b = 15 - 10 = 5
            a = a - b; // a = 15 - 5 = 10
        }

        // Method 3: Using Programming-Specific Tricks
        {
            //XOR Swap: a = a ^ b; b = a ^ b; a = a ^ b;
        }

        // Method 4: swap in one line without temp

        int a=10;
		int b=5;
		a=(a+b)-(b=a);
    }
}
