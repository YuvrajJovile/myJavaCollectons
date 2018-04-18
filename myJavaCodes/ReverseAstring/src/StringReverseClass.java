import java.util.Scanner;

public class StringReverseClass implements IStringReverseInterface {

	public static void main(String args[]) {

		String inputString;
		StringReverseClass stringReverseObject = new StringReverseClass();
		
		System.out.println("Enter the String to be reversed:");
		Scanner scanner = new Scanner(System.in);
		inputString = scanner.nextLine();
		
		long startTime = System.currentTimeMillis();
		System.out.println("Reversed string using Recursion: " + stringReverseObject.recursiveReverse(inputString)
				+ " took " + (System.currentTimeMillis() - startTime) + "ms");
		
		startTime = System.currentTimeMillis();
		System.out.println(
				"Reversed string without using Recursion: " + stringReverseObject.nonRecursiveReverse(inputString)
						+ " took " + (System.currentTimeMillis() - startTime) + "ms");

	}

	@Override
	public String recursiveReverse(String pInputString) {
		if (pInputString == null || pInputString.length() <= 1) 
			return pInputString;
		
		return recursiveReverse(pInputString.substring(1)) + pInputString.charAt(0);
	}

	@Override
	public String nonRecursiveReverse(String pInputString) {
		return new StringBuffer(pInputString.length()).reverse().toString();
	}

}
