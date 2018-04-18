package backFront;

public class BackFrontClass {

	String mUserName,mPassword;
	
	public static void main(String args[]) {
		
		
		BackFrontClass backFrontObject = new BackFrontClass();
		System.out.println(backFrontObject.backFront(""));
		System.out.println(backFrontObject.backFront("an"));
		System.out.println(backFrontObject.backFront("cat"));
		System.out.println(backFrontObject.backFront("zalooon"));
	}

	public String backFront(String pInputString) {

		StringBuilder sb = new StringBuilder(pInputString.length());
		if (!pInputString.isEmpty()&&pInputString.length() <= 4) {
			if (pInputString.length() > 1) {
				sb.append(pInputString.substring(pInputString.length() - 1));
				sb.append(pInputString.substring(1, pInputString.length() - 1));
				sb.append(pInputString.substring(0, 1));
				return sb.toString();
			}else {
				return pInputString;
			}
			
		} else if (pInputString.length() > 4) {
			String subTemp = pInputString.substring(2, pInputString.length());
			sb.append(pInputString.substring(1, 2));
			sb.append(pInputString.substring(0, 1));
			sb.append(subTemp);
			return sb.toString();
		} else {
			return "String is empty";
		}

	}
}
