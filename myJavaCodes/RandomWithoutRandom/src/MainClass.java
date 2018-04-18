import java.util.ArrayList;
import java.util.List;

public class MainClass {

	
	
	public static void main(String[] args) {

		MainClass myClassObj = new MainClass();
		print("Random Number: " + (int) Math.abs(System.nanoTime()%1000));
		List<Integer> randomList = new ArrayList<>();
		myClassObj.generateRandomNumber(randomList);
		myClassObj.printMyRandomList(randomList);

	}

	private void printMyRandomList(List<Integer> randomList) {
		// TODO Auto-generated method stub
		
		randomList.forEach((v->print("Random value: "+v+"\n")));
	}

	private void generateRandomNumber(List<Integer> randomList) {
		// TODO Auto-generated method stub

		while(randomList.size()<=100) {
			
			
			randomList.add((int) Math.abs(System.nanoTime()%1000));
		}
		
	}

	private static void print(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}
}
