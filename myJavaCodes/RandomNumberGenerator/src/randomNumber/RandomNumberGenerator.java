package randomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

	
	public static void main(String args[]) {
		
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		ArrayList<Integer> randomList = new ArrayList<Integer>();
		randomList = randomNumberGenerator.getRandomNumber(randomList);
		randomNumberGenerator.validate(randomList);
	}
	
	
	
	public ArrayList<Integer> getRandomNumber(ArrayList<Integer> numbers) {
	    int count = 10000000,max = 100,min = 1;
		while(numbers.size()<=count) {
			Random random = new Random();
			int randomNumber = random.nextInt(max)+min;
			if(min <= randomNumber && randomNumber <= max) {
				numbers.add(randomNumber);
				}
			
		}
		return numbers;
	}
	
	private void validate(List<Integer> numbers) {
		
		int rangeTestNumber = 0;
		int count = 10,max = 100,min = 1;
		boolean rangeTest = false;
		for(int i=0;i<count;i++) {
		if(min <= numbers.get(i) && numbers.get(i) <= max) {
			rangeTest = true;
			}
			else {
			rangeTest = false;
			rangeTestNumber = numbers.get(i);
			}
		}
		if(rangeTest) {
			System.out.println("Range tests pass");
		}else {
			System.out.println("Range tests FAIL! Number which produced failure is "+rangeTestNumber);

		}
		
		if(numbers.size()==count) {
			System.out.println("Size tests pass");
		}else {
			System.out.println("Size tests FAIL! Actual size is "+numbers.size());
		}
		
	}
}
