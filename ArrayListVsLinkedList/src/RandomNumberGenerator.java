
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

	public static void main(String args[]) {

		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

		ArrayList<Integer> dataArrayList = randomNumberGenerator.getRandomNumberArrayList();
		LinkedList<Integer> dataLinkedList = randomNumberGenerator.getRandomNumberLinkedList();
		print("Time taken by ArrayList: " + randomNumberGenerator.accessArrayList(dataArrayList));
		print("Time taken by LinkedList: " + randomNumberGenerator.accessLinkedList(dataLinkedList));
		print("Time taken for finding First data in random ArrayList: "
				+ randomNumberGenerator.searchForNumber(dataArrayList, 50));
		print("Time taken for finding First data in random LinkedList: "
				+ randomNumberGenerator.insertRandomValuesAtRandomIndecesArrayList(dataArrayList));
		print("Time taken to add 10,000,000 values in random LinkedList: "
				+ randomNumberGenerator.insertRandomValuesAtRandomIndecesLinkedList(dataLinkedList));
		print("Time taken to remove 10,000,000 values in random ArrayList: "
				+ randomNumberGenerator.removeRandomValuesAtRandomIndecesArrayList(dataArrayList));
		print("Time taken to remove 10,000,000 values in random LinkedList: "
				+ randomNumberGenerator.removeRandomValuesAtRandomIndecesLinkedList(dataLinkedList));

	
	}

	public ArrayList<Integer> getRandomNumberArrayList() {
		
		ArrayList<Integer> numbers = new ArrayList<>();
		print("Cooking ArrayList");
		long startTime = System.currentTimeMillis();
		while (numbers.size() <= 10000000) {
			numbers.add(new SecureRandom().nextInt());
		}
		print("Time taken: " + (currentTime() - startTime) + "ms");
		return numbers;
	}

	public String insertRandomValuesAtRandomIndecesArrayList(ArrayList<Integer> pCollectionData) {
		print("Inserting values to Array List..");
		int size = pCollectionData.size();
		long startTime = currentTime();
		for (int i = 0; i < size; i++) {
			pCollectionData.set(i, new SecureRandom().nextInt(size));
		}

		return String.valueOf(currentTime() - startTime+ "ms");
	}
	
	//removeRandomValuesAtRandomIndeces
	public String removeRandomValuesAtRandomIndecesArrayList(ArrayList<Integer> pCollectionData) {
		print("Removing values from Array List..");
		long startTime = currentTime();
		for (int i = 0; i < pCollectionData.size(); i++) {
			pCollectionData.remove(i);
		}

		return String.valueOf(currentTime() - startTime+ "ms");
	}
	
	public String removeRandomValuesAtRandomIndecesLinkedList(LinkedList<Integer> pCollectionData) {
		print("Removing values from Linked List..");
		long startTime = currentTime();
		for (int i = 0; i < pCollectionData.size(); i++) {
			pCollectionData.remove(i);
		}
		return String.valueOf(currentTime() - startTime+ "ms");
	}
	
	public String insertRandomValuesAtRandomIndecesLinkedList(LinkedList<Integer> pCollectionData) {
		print("Inserting  values to Linked List..");
		int size = pCollectionData.size();
		long startTime = currentTime();
		for (int i = 0; i < size; i++) {
			pCollectionData.set(i, new SecureRandom().nextInt(size));
		}

		return String.valueOf(currentTime() - startTime+ "ms");
	}

	public String accessCollection(Collection pCollectionData) {
		print("Accessing values from Collection..");
		long startTime = currentTime();
		for (Iterator iterator = pCollectionData.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
		}
		return String.valueOf(currentTime() - startTime+ "ms");
	}

	public String accessArrayList(ArrayList<Integer> pCollectionData) {
		print("Accessing  values from Array List..");
		long startTime = currentTime();
		for (Iterator iterator = pCollectionData.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
		}
		return String.valueOf(currentTime() - startTime+ "ms");
	}

	public String accessLinkedList(LinkedList<Integer> pCollectionData) {
		print("Accessing  values from Linked List..");
		long startTime = currentTime();
		for (Iterator iterator = pCollectionData.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
		}
		return String.valueOf(currentTime() - startTime+ "ms");
	}

	public String searchForNumber(Collection pCollectionData, int pNumber) {
		print("Searching value in Collection..");
		long startTime = currentTime();
		for (Iterator iterator = pCollectionData.iterator(); iterator.hasNext();) {
			Integer data = (Integer) iterator.next();
			if (data == pNumber)
				return String.valueOf(currentTime() - startTime+ "ms");
		}
		return String.valueOf(currentTime() - startTime+ "ms");
	}

	public LinkedList<Integer> getRandomNumberLinkedList() {
		LinkedList<Integer> numbers = new LinkedList<>();
		print("Cooking LinkedList");
		long startTime = currentTime();
		while (numbers.size() <= 10000000) {
			numbers.add(new SecureRandom().nextInt());
		}
		print("Time taken: " + (currentTime() - startTime) + "ms");
		return numbers;
	}

	private static void print(String data) {
		System.out.println(data);
	}

	private static long currentTime() {
		return System.currentTimeMillis();
	}
}
