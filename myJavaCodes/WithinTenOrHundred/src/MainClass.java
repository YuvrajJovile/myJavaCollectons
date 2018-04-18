
public class MainClass {

	
	public static void main(String args[]) {

		WithinTenOrHundredClass wh = new WithinTenOrHundredClass();

		System.out.println(wh.nearHundred(93));
		System.out.println(wh.nearHundred(90));
		System.out.println(wh.nearHundred(89));
		System.out.println(wh.nearHundred(110));
		System.out.println(wh.nearHundred(209));
		System.out.println(wh.nearHundred(250));
		System.out.println(wh.nearHundred(211));
	}
	
}
