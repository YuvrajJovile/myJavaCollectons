package multipleOf3Or5;

public class MainClass {

	public static void main(String args[]) {
		MultipleOfThreeOrFive mv = new MultipleOfThreeOrFive();
		System.out.println(mv.multipleOf3Or5Only(25));
		System.out.println(mv.multipleOf3Or5Only(26));
		System.out.println(mv.multipleOf3Or5Only(15));
		System.out.println(mv.multipleOf3Or5Only(6));
	}
}
