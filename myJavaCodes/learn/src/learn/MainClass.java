package learn;

import java.util.ArrayList;

public class MainClass {
	
	
	
public static void main(String args[]) {
	System.out.print("Hello World\n");
	int a= 5;
	int result = addFunc(a);
	System.out.print(result+"\n");
	ArrayList<String> data = new ArrayList<>();
	data.add("one");
	System.out.print(data.size()+"One Size\n");
	ArrayList<String> dataTwo = data;
	dataTwo.add("Two");
	System.out.print(data.size()+"One Size\n");
	System.out.print(dataTwo.size()+"Two Size\n");
}

static int c =0;

public static int addFunc(int a) {
	c = a++;
	System.out.print("a=="+c);
	return a++;
}

}
