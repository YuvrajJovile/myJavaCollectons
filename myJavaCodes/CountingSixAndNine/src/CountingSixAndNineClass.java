import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class CountingSixAndNineClass {

	public static void main(String args[]) {

	
		for (String data : args) {
			System.out.println("Arguements:"+data);
		}
		CountingSixAndNineClass cs = new CountingSixAndNineClass();
		System.out.println(cs.countFunc(cs.generateRandomNumber()));
	}

	public ArrayList<Integer> generateRandomNumber() {
		ArrayList<Integer> list = new ArrayList();

		System.out.println("Adding RandomNumbers..");
		while (list.size() <= 10000000) {
			list.add(new SecureRandom().nextInt(100) + 1);
		}
		System.out.println("RandomNumbers Added..");
		return list;
	}

	public int countFunc(ArrayList<Integer> list) {

		System.out.println("Checking for 6's and 9's..");
		int count = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 6 || list.get(i) == 9) {
				count++;
				System.out.println("RandomNumber==" + list.get(i));
			}
		}

		return count;
	}
}
