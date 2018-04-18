import java.util.Scanner;

public class MainClass {

	public static void main(String args[]) {

		
		IStringReverseInterface iStringReverseInterface =  new StringReverseClass();
		
		System.out.println("Enter your String: ");
		System.out.println("Reversed String is: "+iStringReverseInterface.nonRecursiveReverse(new Scanner(System.in).nextLine()));
	}
}
