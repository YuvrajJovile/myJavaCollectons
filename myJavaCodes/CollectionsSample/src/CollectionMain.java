import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class CollectionMain {

	public static void main(String args[]) {

		// list
		List<String> stringList = new ArrayList<>();
		List<String> stringLinkedList = new LinkedList<>();
		List<String> stringVector = new Vector<>();
		List<String> stringStack = new Stack<>();

		Vector<String> vectorString = new Vector<>();
		Stack<String> stackString = new Stack();

		stringList.add("oneList");
		stringList.add("TwoList");
		printCollection(stringList);

		stringLinkedList.add("oneLinkedList");
		stringLinkedList.add("TwoLinkedList");
		printCollection(stringLinkedList);

		stringVector.add("oneVector");
		stringVector.add("TwoVector");
		printCollection(stringVector);

		vectorString.addElement("vectorString");
		printCollection(vectorString);

		stackString.push("StackStringOne");
		stackString.push("StackStringTwo");
		stackString.push("StackStringThree");
		printCollection(stackString);

		print(String.valueOf(stackString.search("StackStringOne")));
		print(stackString.peek());
		printCollection(stackString);
		print(stackString.pop());
		printCollection(stackString);
		print(stackString.pop());
		print(stackString.pop());
		print(String.valueOf(stackString.empty()));
		printCollection(stackString);

		// Set
		Set<String> hashSet = new HashSet<>();
		Set<String> linkedHashSet = new LinkedHashSet<>();
		Set<String> treeSet = new TreeSet<>();

		SortedSet<String> sortedSet = new TreeSet<>();
		SortedSet<String> sortedSetWithComparator = new TreeSet<>(new MyComparatorClass());
		NavigableSet<String> navigableSet = new TreeSet<>();

		hashSet.add("HashSetone");
		hashSet.add("HashSetTwo");
		hashSet.add("HashSetThree");
		hashSet.add("HashSetThree");
		printCollection(hashSet);

		linkedHashSet.add("LinkedHashSetone");
		linkedHashSet.add("LinkedHashSetTwo");
		linkedHashSet.add("LinkedHashSetTwo");
		linkedHashSet.add("LinkedHashSetThree");
		printCollection(linkedHashSet);

		treeSet.add("TreeSetA");
		treeSet.add("TreeSetB");
		treeSet.add("TreeSetC");
		printCollection(treeSet);

		sortedSet.add("SortedTreeSetA");
		sortedSet.add("SortedTreeSetB");
		sortedSet.add("SortedTreeSetC");
		printCollection(sortedSet);

		sortedSetWithComparator.add("SortedTreeSetWithComparatorA");
		sortedSetWithComparator.add("SortedTreeSetWithComparatorB");
		sortedSetWithComparator.add("SortedTreeSetWithComparatorC");
		printCollection(sortedSetWithComparator);

		navigableSet.add("NavigableTreeSetA");
		navigableSet.add("NavigableTreeSetB");
		navigableSet.add("NavigableTreeSetC");
		printCollection(navigableSet);
		print("Ceiling-" + navigableSet.ceiling("NavigableTreeSetA"));
		print("Ceiling-" + navigableSet.ceiling("NavigableTreeSetZ"));
		print("First" + navigableSet.first());
		print("Floor-" + navigableSet.floor("NavigableTreeSetB"));
		print("PollFirst-" + navigableSet.pollFirst());
		print("PollLast-" + navigableSet.pollLast());
		printCollection(navigableSet);

		// queue
		Queue<String> priorityQueue = new PriorityQueue<>();
		Queue<String> blockingQueue = new PriorityBlockingQueue<>();
		Queue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();

		priorityQueue.add("priorityQueueA");
		priorityQueue.add("priorityQueueB");
		priorityQueue.add("priorityQueueC");
		printCollection(priorityQueue);
		print("Peek-" + priorityQueue.peek());
		print("Poll-" + priorityQueue.poll());
		print("Element-" + priorityQueue.element());
		printCollection(priorityQueue);
		print("Poll-" + priorityQueue.poll());
		printCollection(priorityQueue);

		// Map
		Map<String, String> hashMap = new HashMap<>();
		Map<String, String> linkedHashMap = new LinkedHashMap<>();
		Map<String, String> weakHashMap = new WeakHashMap<>();// entry will go to garbage collection if key is not in
																// use, so the size of the map differs at different
																// point

		Map<String, String> identityHashMap = new IdentityHashMap<>();

		SortedMap<String, String> sortedMap = new TreeMap<>(new MyComparatorClass());
		NavigableMap<String, String> navigableMap = new TreeMap<>();

		hashMap.put("one", "HashOne");
		hashMap.put("two", "HashTwo");
		hashMap.put("three", "HashThree");
		hashMap.put("four", "HashFour");
		print("HashCode-" + hashMap.hashCode());
		printMap(hashMap);
		print("getHashWithKey-" + hashMap.get("two"));
		hashMap.put("two", "newHashTwo");
		print("getHashWithKey-" + hashMap.get("two"));
		hashMap.remove("one");
		printCollection(hashMap.keySet());
		printCollection(hashMap.values());
		printMap(hashMap);
		print("compare-" + String.valueOf(hashMap.get("three").equals(hashMap.get("two"))));
		print("Size: " + hashMap.size());
		hashMap.put(new String("three"), "new third value");
		print("Size: " + hashMap.size());

		linkedHashMap.put("one", "HashOne");
		linkedHashMap.put("two", "HashTwo");
		linkedHashMap.put("three", "HashThree");
		linkedHashMap.put("four", "HashFour");
		printMap(linkedHashMap);

		weakHashMap.put("one", "weakHashMapHashOne");
		weakHashMap.put("two", "weakHashMapHashTwo");
		weakHashMap.put("three", "weakHashMapHashThree");
		weakHashMap.put("four", "weakHashMapHashFour");
		weakHashMap.put("five", "weakHashMapHashFive");
		printMap(weakHashMap);

		// different memory location, uses == while hashmap uses .equals
		identityHashMap.put("one", "identityHashMapHashOne");
		identityHashMap.put("two", "identityHashMapHashTwo");
		identityHashMap.put("three", "identityHashMapHashThree");
		identityHashMap.put("four", "identityHashMapFour");
		identityHashMap.put("five", "identityHashMapFive");
		print("Size: " + identityHashMap.size());
		identityHashMap.put(new String("one"), "identityHashMapFive");
		print("Size: " + identityHashMap.size());
		printMap(identityHashMap);
		print("Identity-" + identityHashMap.hashCode());
		print("compare-" + String.valueOf(identityHashMap.get("three").equals(identityHashMap.get("three"))));

		sortedMap.put("A", "value of A");
		sortedMap.put("D", "value of D");
		sortedMap.put("B", "value of B");
		sortedMap.put("E", "value of E");
		sortedMap.put("C", "value of C");
		sortedMap.put("F", "value of F");
		printCollection(sortedMap.values());
		print("First key-" + sortedMap.firstKey());
		print("Last key-" + sortedMap.lastKey());

		print("NavigableMap");
		navigableMap.put("A", "value of A");
		navigableMap.put("D", "value of D");
		navigableMap.put("B", "value of B");
		navigableMap.put("E", "value of E");
		navigableMap.put("C", "value of C");
		navigableMap.put("F", "value of F");
		printCollection(navigableMap.values());
		print("reverse of map" + navigableMap.descendingMap());

		// dictionary
		Dictionary<String, String> dictionary = new Hashtable<>();
		Properties properties = new Properties();

		print("Dictionary");
		dictionary.put("a", "value of a");
		dictionary.put("b", "value of b");
		dictionary.put("c", "value of c");
		dictionary.put("d", "value of d");
		printDictionary(dictionary.elements());

		properties = System.getProperties();
		printProperties(properties.elements());

	}

	private static void printDictionary(Enumeration<String> elements) {

		while (elements.hasMoreElements()) {
			print(elements.nextElement());
		}
	}

	private static void printProperties(Enumeration<Object> elements) {

		while (elements.hasMoreElements()) {
			print(elements.nextElement().toString());
		}
	}

	private static void printMap(Map<String, String> mapObj) {
		long startTime = System.currentTimeMillis();
		for (Map.Entry<String, String> data : mapObj.entrySet()) {
			System.out.println("key: " + data.getKey() + " value: " + data.getValue());
		}
		System.out.println("Time taken : " + (System.currentTimeMillis() - startTime) + " ms\n");
	}

	private static void printCollection(Collection<String> pCollectionObject) {
		long startTime = System.currentTimeMillis();
		for (String data : pCollectionObject) {
			System.out.println(data);
		}
		System.out.println("Time taken : " + (System.currentTimeMillis() - startTime) + " ms\n");
	}

	private static void print(String data) {
		System.out.println(data);
	}
}
