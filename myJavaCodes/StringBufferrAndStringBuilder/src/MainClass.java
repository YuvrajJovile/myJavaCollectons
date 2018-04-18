
public class MainClass {

	
	public static void main(String args[]) {
		MainClass mc = new MainClass();
		mc.stringConcat();
	}
	
	private void stringConcat() {
		
		StringBuffer sbf = new StringBuffer("Java");
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 100000; i++) {
			sbf.append("StringBuffer");
		}
		
		System.out.println("Time taken by String buffer is:"+(System.currentTimeMillis()-startTime) +"ms");
		
		StringBuilder sb = new StringBuilder("Java");
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 100000; i++) {
			sb.append("StringBuilder");
		}
		
		System.out.println("Time taken by String bulder is:"+(System.currentTimeMillis()-startTime) +"ms");
		
	}
}
