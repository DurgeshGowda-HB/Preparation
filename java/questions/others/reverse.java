package questions.others;

public class reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
int n =1234;
int a=0;

while (n>0) {
	int d= n%10;//gets last digit 
	n=n/10;// remove last digit // for sum of digit remove the *10
	a=a*10+d;
	
	
	
}
System.out.println(a);


//reversestring

{
	String O="NithinBHARADWAJ";
    String R="";

for (int i=O.length()-1;i>=0;i--) {
	
	 R+=O.charAt(i);
}
System.out.println("reverts string isd "+R);


}	
	}
}
