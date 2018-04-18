package randomNumber;

import java.util.ArrayList;
import java.util.List;

public class UserInterfaceClass { 

	
	public static void main(String args[]) {
		RandomNumberGenerator randomClass = new RandomNumberGenerator();
		ArrayList<Integer> randomNumbersList = new ArrayList<Integer>();
		randomClass.getRandomNumber(randomNumbersList);
		
		for (int i = 0; i < randomNumbersList.size(); i++) {
			System.out.println(randomNumbersList.get(i));
		}
		
		/*ArrayList data = new ArrayList();
		data.add("hi");
		data.add(2);
		List comon = new ArrayList();
		comon.add("hint");
		comon.add(1);*/
		
		
	}
}
