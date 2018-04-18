import java.util.HashMap;
import java.util.Scanner;

public class MainClass {

	static HashMap<String, Boolean> mFlagData = new HashMap();

	public static void main(String args[]) {

		/*
		 * boolean flag = !((true && false) || (true && false)); print(flag);
		 * print(Boolean.parseBoolean("true"));
		 */

		String equation = null;
		Scanner scanner = new Scanner(System.in);
		print("Enter the equation");
		equation = scanner.nextLine();

		boolean result = getBooleanResult(equation);
		// print("Result" + result);

	}

	private static boolean getBooleanResult(String equation) {

		char equationChar[] = new char[equation.length()];
		equationChar = equation.toCharArray();
		int i = 0;
		boolean flag = false;
		for (i = 0; i + 1 < equationChar.length; i++) {
			if (equationChar[i] == ('&')) {
				flag = findBoolean(equationChar[i - 1], equationChar[i + 1], 0);
				print(findBoolean(equationChar[i - 1], equationChar[i + 1], 0));
				break;
			} else if (equationChar[i] == ('|')) {
				flag = findBoolean(equationChar[i - 1], equationChar[i + 1], 1);
				print(findBoolean(equationChar[i - 1], equationChar[i + 1], 1));
				break;
			} else if (equationChar[i] == ('!')) {
				flag = findBoolean(equationChar[i + 1], equationChar[i + 1], 2);
				print(findBoolean(equationChar[i + 1], equationChar[i + 1], 2));
				break;
			} else {
				// print(i + "Iteration " + getBooleanResult(equation.substring(i)));
			}
		}
		 return flag;

		/*print("I value==" + i);
		if (equationChar[i] < equationChar.length) {
			if (equationChar[i] == '&') {
				return flag && getBooleanResult(equation.substring(i));
			} else if (equationChar[i] == '|') {
				return flag || getBooleanResult(equation.substring(i));
			}
		}

		return !getBooleanResult(equation);*/

	}

	private static boolean findBoolean(char c, char d, int flag) {
		if (!mFlagData.containsKey(new String().valueOf(c))) {
			mFlagData.put(new String().valueOf(c), getBoolValueFromUser(new String().valueOf(c)));
		}
		if (!mFlagData.containsKey(new String().valueOf(d))) {
			mFlagData.put((new String().valueOf(d)), getBoolValueFromUser(new String().valueOf(d)));
		}

		switch (flag) {
		case 0:
			return mFlagData.get((new String().valueOf(c))) && mFlagData.get((new String().valueOf(d)));
		case 1:
			return mFlagData.get((new String().valueOf(c))) || mFlagData.get((new String().valueOf(d)));
		case 2:
			return !mFlagData.get((new String().valueOf(d)));

		default:
			return false;

		}

	}

	private static Boolean getBoolValueFromUser(String pData) {
		print("Enter the boolean value for: " + pData);
		return Boolean.valueOf(new Scanner(System.in).nextLine());
	}

	private boolean recursive(String equation) {

		return recursive(equation.substring(0));
	}

	private static void print(String data) {
		System.out.println(data);
	}

	private static void print(int data) {
		System.out.println(String.valueOf(data));
	}

	private static void print(float data) {
		System.out.println(String.valueOf(data));
	}

	private static void print(boolean data) {
		System.out.println(String.valueOf(data));
	}
}
