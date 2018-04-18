import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class MainClass {

	public static String[]  stringArray =  { "Z","T","S","G","A" };
	public static void main(String[] args) {
		
		
		
		
		ArrayList<String> stringArrayList = new ArrayList<>();
		LinkedList<String> stringLinkedList = new LinkedList<>();
		Vector<String> stringVector = new Vector<>();
		Stack<String> stringStack = new Stack<>();
		
		//adding datas
		stringArrayList.addAll(getList());
		stringLinkedList.addAll(getList());
		stringVector.addAll(getList());
		stringStack.addAll(getList());
		
		
		//sorting data
		Collections.sort(stringArrayList);
		Collections.sort(stringLinkedList);
		Collections.sort(stringVector);
		Collections.sort(stringStack);
		
		
		//printing after sort
		printCollection(stringArrayList);
		printCollection(stringLinkedList);
		printCollection(stringVector);
		printCollection(stringStack);
	}
	
	private static void printCollection(Collection<String> pCollection) {
		// TODO Auto-generated method stub
		
		System.out.println("\n\t------\t\n");
		pCollection.forEach((v->System.out.print("\nData :"+v)));
	}

	private static List getList() {
		// TODO Auto-generated method stub
		return Arrays.asList(stringArray);
	}
	
	
	
	
}
