package primeOrNot;


public class MainClass {
	
	
	
	public static void main(String args[]) {
		 MainClass mainclass   = new MainClass();
		 int[] a = {5,6,3,13};
		 mainclass.getInputFunc(a);
	}
	
	
	private void getInputFunc(int[] a) {

		 MainClass mainclass   = new MainClass();
		mainclass   = new MainClass();
		for(int i =0;i<a.length;i++) {
			System.out.println(mainclass.checkForPrime(a[i]));
		}
		
	}
	
	private String checkForPrime(int val) {
		
		for(int i=2;i<val;i++) {
			if(val%i==0) {
				return val+ " is not a prime";
			}
		}
		
		return val+ " a prime";
	}

}
