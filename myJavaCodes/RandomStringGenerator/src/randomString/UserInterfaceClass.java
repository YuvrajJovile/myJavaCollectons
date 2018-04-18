package randomString;

import java.util.ArrayList;

public class UserInterfaceClass {

	
	public static void main(String args[]) {
		
		RandomStringGenerator rg = new RandomStringGenerator();
		System.out.println(rg.randomString(7));
		rg.randomStringList(new ArrayList<String>());
	}
}
