package notAstring;

public class MainClass {

	public static void main(String args[]) {

		MainClass mainclass = new MainClass();

		System.out.println("Arguements==" + args[1]);

		System.out.println(mainclass.notAString("going to happen"));
		System.out.println(mainclass.notAString("a"));
		System.out.println(mainclass.notAString("not interested"));

	}

	public String notAString(String str) {

		String target = "not";

		if (str.contains(target)) {
			return str;
		} else {
			return target + " " + str;
		}

	}

}
