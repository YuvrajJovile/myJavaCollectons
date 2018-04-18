package multipleOf3Or5;

public class MultipleOfThreeOrFive {

	
	
	public static void main(String args[]) {
		
		MultipleOfThreeOrFive mv = new MultipleOfThreeOrFive();
		System.out.println(mv.multipleOf3Or5Only(9));
		System.out.println(mv.multipleOf3Or5Only(10));
		System.out.println(mv.multipleOf3Or5Only(15));
		System.out.println(mv.multipleOf3Or5Only(13));
		
	}
	
	public boolean multipleOf3Or5Only(int n) {
		return (n%3==0 && n%5==0) ?false :(n%3==0||n%5==0)?true:false;
	}

}
