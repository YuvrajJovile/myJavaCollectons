
public class WithinTenOrHundredClass {

	
	public static void main(String args[]) {

		WithinTenOrHundredClass wh = new WithinTenOrHundredClass();

		System.out.println(wh.nearHundred(110));
		System.out.println(wh.nearHundred(90));
		System.out.println(wh.nearHundred(89));
		System.out.println(wh.nearHundred(200));
		System.out.println(wh.nearHundred(203));
		System.out.println(wh.nearHundred(250));
	}
	
	public  boolean nearHundred(int a) {
		return (a>=90&&a<=110)||(a>=190&&a<=210)?true:false;
	}
	
}
