
public class MainClass {
	public static void main(String args[]) {
		PosNegClass pc = new PosNegClass();
		System.out.println(pc.posNeg(1, -1, false));
		System.out.println(pc.posNeg(-1, 1, false));
		System.out.println(pc.posNeg(1, 1, false));
		System.out.println(pc.posNeg(-1, -1, false));
		
		System.out.println(pc.posNeg(-1, -1, true));
		System.out.println(pc.posNeg(-1, 1, true));
		System.out.println(pc.posNeg(1, 1, true));
	}
}
