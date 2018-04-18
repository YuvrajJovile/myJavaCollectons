

public class MainClass {
	
	
	
public static void main(String[] args) {
	
	
MainClass mainClass = new MainClass();
System.out.println(mainClass.isOneOrSum10(10,10));
System.out.println(mainClass.isOneOrSum10(9,9));
System.out.println(mainClass.isOneOrSum10(9,1));
}




public  boolean isOneOrSum10(int a,int b) {
	
	if(a==10 || b==10 || (a+b)==10) {
		return true;
	}
	else {
		return false;
	}
}

}
