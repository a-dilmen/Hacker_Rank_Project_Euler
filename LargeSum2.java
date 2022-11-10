package ProjectEuler;

import java.util.Scanner;


public class LargeSum2 {
	public static void main(String[] args) {
		// Large sum
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine(); // to consume \n remaining from nextInt()

		// Creation of string array to store every input 50 digit number as String
		String[] stringArray = new String[n];

		// Creation of char[58] to convert strings to char[] and sum on char level
		// Creation of char[] 8 indices larger to store 50 th and more chars come from
		// summation input upto 10^3 50 digits #
		int spareChars = 8;
		char[] character = new char[50 + spareChars];
		// initialization of initially empty char[] as (' '-32) which has integer value
		// of 0
		for (int i = 0; i < character.length; i++) {
			character[i] = ' ' - 32;
		}
		// receiving and storing 50 digit numbers as string
		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = scanner.nextLine();
		}

		// To sum each digit in char level and update char[]
		// looping for each char
		for (int j = spareChars; j < character.length; j++) {
			// looping for String[]
			for (int i = 0; i < stringArray.length; i++) {
				// updating char at j by summing integer values of char
				character[j] += (char) stringArray[i].charAt(j - spareChars);
			}
		}
		// integer casting of char[]
		int[] char2int = new int[character.length];
		for (int i = 0; i < char2int.length; i++) {
			char2int[i] = (int) character[i];
		}
		// converting reminders to digits and updating trailing chars in the char array
		for (int i = char2int.length - 1; i >= spareChars/2; i--) {
			int x = char2int[i] - 48 * n;
			if (x<=0) {
				x = 0;
				continue;
			}
			if (x < 100 && x > 9) {
				char2int[i - 1] = char2int[i - 1] + (x) / 10;
			} else if (x < 1000) {
				char2int[i - 2] = char2int[i - 2] + (x) / 100;
				char2int[i - 1] = char2int[i - 1] + (x - (x / 100) * 100) / 10;
			} else if (x < 10000) {
				char2int[i - 3] = char2int[i - 3] + (x) / 1000;
				char2int[i - 2] = char2int[i - 2] + (x - (x / 1000) * 1000) / 100;
				char2int[i - 1] = char2int[i - 1] + (x - (x / 1000) * 1000 - (((x % 1000)/100)*100))/10;
			}
			char2int[i] = (x % 10);
		}
		// to convert reminders to digits and updating trailing chars in the char[0-spareChar] array
		for (int i = spareChars; i > spareChars/2; i--) {
			int z = char2int[i];
			if (z<100&&z > 9) {
				char2int[i-1]+= z/10; 
			}else if (z < 1000) {
				char2int[i - 2] = char2int[i - 2] + (z) / 100;
				char2int[i - 1] = char2int[i - 1] + (z - (z / 100) * 100) / 10;
			} else if (z < 10000) {
				char2int[i - 3] = char2int[i - 3] + (z) / 1000;
				char2int[i - 2] = char2int[i - 2] + (z - (z / 1000) * 1000) / 100;
				char2int[i - 1] = char2int[i - 1] + (z - (z / 1000) * 1000 - (((z % 1000)/100)*100))/10;
			}
			char2int[i] = z%10;
		}
		// string manipulation to write first 10 digits
		String str = "";
		int k = 0;
		for (int i = 0; i < character.length; i++) {
			if (char2int[i] != 0) {
				k = i;
				break;
			}
		}
		for (int j = k; j < char2int.length; j++) {
			str += char2int[j];
		}
		System.out.println(str.substring(0, 10));
		scanner.close();

	}

}
