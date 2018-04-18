import java.util.Comparator;

public class MyComparatorClass implements Comparator<String>{

	@Override
	public int compare(String argOne, String argTwo) {
	
		if(argOne.compareTo(argTwo)>=1) return -1;
		else if(argOne.compareTo(argTwo)<1) return +1;
		return 0;
	}
	
}
