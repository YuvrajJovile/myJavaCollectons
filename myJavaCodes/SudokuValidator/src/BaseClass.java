import java.util.Scanner;

public class BaseClass {

	public void print(String pData) {
		System.out.println(pData);
	}
	
	
	public Integer scanInt() {
		return new Scanner(System.in).nextInt();
	}
}
