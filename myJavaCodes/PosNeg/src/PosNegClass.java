
public class PosNegClass {

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

	public boolean posNeg(int a, int b, boolean negative) {
		
			/*if (a < 1 && b < 1) {
				return negative;
			} else if (a < 1 || b < 1 ) {
				return !negative;
			}
			else{
				return false;
			}*/
			
			return (a < 1 && b < 1)?negative:((a < 1 || b < 1 )?!negative:false);

	}

}
