package com.dilmen;

import java.util.Scanner;

public class EvenFibonacciNumbers {
	static long fibArray[] = new long[82];

	public static void main(String[] args) {
		fibArray[0] = 1;
		fibArray[1] = 1;
		fibArray[2] = 2;
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			long nTemp = scanner.nextLong();
			long n = 1;
			while (fibonacciMemo(n) <= nTemp) {
				n++;
			}
			long sum = 0;
			for (int j = 2; j < n; j += 3) {
				sum += fibArray[j];
				
			}
			System.out.println(sum);			
		}
	}
	public static long fibonacciMemo(long n) {
		long fibValue = 1;
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else if (fibArray[(int) n] != 0) {
			return fibArray[(int) n];
		} else {
			fibValue = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
			fibArray[(int) n] = fibValue;
			return fibValue;
		}
	}
}