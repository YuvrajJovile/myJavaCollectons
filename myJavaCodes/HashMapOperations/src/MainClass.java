import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainClass {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		setMapData(map);
		viewEntery(map);
		searchEntry(map, 40);
		editEntry(map,50);
		removeEntry(map,60);
	}

	private static void removeEntry(Map<Integer, String> pMap, int pVal) {
		// TODO Auto-generated method stub
		print("Remove Entry");
		Instant startInstance = Instant.now();
		pMap.remove(pVal);
		print("\nTimeTaken: "+ Duration.between(startInstance,Instant.now()).toMillis()+"ms\n");
		
	}

	private static void editEntry(Map<Integer, String> pMap, int pVal) {
		// TODO Auto-generated method stub
		print("Edit Entry");
		Instant startInstance = Instant.now();
		pMap.put(pVal, randomString());
		print("\nTimeTaken: "+ Duration.between(startInstance,Instant.now()).toMillis()+"ms\n");
	}

	private static void searchEntry(Map<Integer, String> pMap, int pVal) {
		// TODO Auto-generated method stub
		Instant startInstance = Instant.now();
		print("Search Entry = " + pVal + "\tValue==" + pMap.get(pVal));
		print("\nTimeTaken: "+ Duration.between(startInstance,Instant.now()).toMillis()+"ms\n");
	}

	private static void viewEntery(Map<Integer, String> map) {
		// TODO Auto-generated method stub
		Instant startInstance = Instant.now();
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			print("\nkey= " + ((Map.Entry) iterator.next()).getKey() + "\t value= "
					+ ((Map.Entry) iterator.next()).getValue());
		}
		map.forEach((k,v)->print("\nKey= "+k+" value= "+v));
		print("\nTimeTaken: "+ Duration.between(startInstance,Instant.now()).toMillis()+"ms\n");

	}

	private static void print(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

	private static Map<Integer, String> setMapData(Map<Integer, String> map) {
		// TODO Auto-generated method stub
		Instant startInstance = Instant.now();
		System.out.println("Processing..");
		while (map.size() < 100) {
			map.put(map.size() + 1, randomString());
		}
		print("\nTimeTaken: "+ Duration.between(startInstance,Instant.now()).toMillis()+"ms\n");
		return map;
	}

	public static String randomString() {

		return generateChar()+generateChar()+generateChar();
	}
	
	public static String generateChar() {
		return  ""+"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(new SecureRandom()
						.nextInt("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".length()));
	}
	
	

}
