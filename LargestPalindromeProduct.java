package ProjectEuler;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class LargestPalindromeProduct {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());
				System.out.println(palindrome(n));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			} 
		});

		bufferedReader.close();
	}

	static String[] palindrome = new String[900];

	public static int palindrome(int number) {
		
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		int[] b = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] c = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		char[] charStr = new char[6];
		String goal = "";
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				for (int j2 = 0; j2 < c.length; j2++) {
					charStr[2] = Character.valueOf((char) (c[j2] + 48));
					charStr[3] = Character.valueOf((char) (c[j2] + 48));
					for (int j3 = 0; j3 < charStr.length; j3++) {
						goal += String.valueOf(charStr[j3]);
					}
				}
				charStr[1] = Character.valueOf((char) (b[j] + 48));
				charStr[4] = Character.valueOf((char) (b[j] + 48));

			}
			charStr[0] = Character.valueOf((char) (a[i] + 48));
			charStr[5] = Character.valueOf((char) (a[i] + 48));

		}
		String rgoal = goal.substring(600);
		for (int i = 0; i < (rgoal.length()); i += 6) {

			palindrome[i / 6] = rgoal.substring(i, i + 6);
		}
		Arrays.sort(palindrome);

		for (int i = 1; i < palindrome.length; i++) {
			if (Integer.valueOf(palindrome[i]) >= number) {
				for (int j = i - 1;; j--) {
					if (checkMultiple(Integer.valueOf(palindrome[j]))) {
						return Integer.valueOf(palindrome[j]);
					}
				}
			}
		}

		return number;
	}

	static boolean checkMultiple(int num) {
		for (int i = 100; i <= 999; i++) {
			for (int j = 100; j <= 999; j++) {

				if ((i * j) == num) {
					return true;
				}
			}
		}
		return false;
	}

}

