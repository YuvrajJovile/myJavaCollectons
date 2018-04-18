package randomString;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class RandomStringGenerator {

	
	public static void main(String args[]) {
		RandomStringGenerator rg = new RandomStringGenerator();
		System.out.println(rg.randomString(6));
		rg.randomStringList(new ArrayList<String>());
	}
	
	
	public String randomString(int length) {
		String alfa = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom random = new SecureRandom();
		StringBuilder sb  = new StringBuilder(length);
		while(sb.length()<=length) {
			sb.append(alfa.charAt(random.nextInt(alfa.length())));
		}
		return sb.toString();
	}
	
	public void randomStringList(ArrayList<String> list) {
		System.out.println("Processing..");
		RandomStringGenerator rg = new RandomStringGenerator();
		int count = 10000000;
		int length = 6;
		Instant start = Instant.now();
		while(list.size()<=count) {
			list.add(rg.randomString(length));
		}
		Instant end = Instant.now();
		Duration difference = Duration.between(start, end);
		
		System.out.println("Time taken:"+difference.toMillis());
	}
}
