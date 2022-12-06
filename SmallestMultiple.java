package com.dilmen;

import java.util.Scanner;

public class SmallestMultiple {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			long[] numbers = new long[n];
			for (int j = 0; j < n; j++) {
				numbers[j] = j + 1;
			}
			System.out.println(LCM(numbers, 0));
		}
	}
	// recursive gcd to call in lcm calculation -> lcm(a,b) = a*b/gcd(a,b)
	public static long gcd(long a, long b) {
		return b == 0L ? a : gcd(b, a % b);

	}

	public static long lcm(long a, long b) {
		long lcml = a * b / gcd(a, b);
		return lcml;
	}
	//LCM for arrays
	private static long LCM(long[] numbers, int i) {
		try { 	// Exception handling for possible test case(0) {1,1}
			// to manage IndexOutOfBoundsException
			if (i + 2 == numbers.length) {
				return lcm(numbers[i], numbers[i + 1]);
			} else {
				return lcm(numbers[i], LCM(numbers, i + 1));
			}
		} catch (IndexOutOfBoundsException e) {

		}
		return numbers[0];
	}
}
