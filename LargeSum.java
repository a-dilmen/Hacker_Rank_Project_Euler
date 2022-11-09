
package ProjectEuler;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class LargeSum {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine(); // To consume new line after nextInt()
		BigInteger reallyb = new BigInteger(scanner.nextLine());
		n--;
		while (n>0) {
			BigInteger b = new BigInteger(scanner.nextLine());
			reallyb = reallyb.add(b);
			n--;
		}
		String str = reallyb.toString();
		System.out.println(str.substring(0, 10));
		scanner.close();
	}

}



