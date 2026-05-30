package questions.others;

public class palandrom {

    public static void main(String[] args) {
        
    
        String O="nin";
		String R="";

		for (int i=O.length()-1;i>=0;i--) {
			
			 R+=O.charAt(i);
		}
		
		if (O.equals(R)){
			
			System.out.println("PALANDROM");
		}
		else {System.out.println("NOT PALANDROM ");}
		
		System.out.println("reverts string isd "+R);

		// TODO Auto-generated method stub
}

}