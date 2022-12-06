package com.dilmen;

import java.util.Scanner;

public class Ten1001stPrime {
	static int[] primeArray = new int[10001];
	public static void main(String[] args) {

		fillPrimeArray();
		Scanner scanner = new Scanner(System.in);
		int t =scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			System.out.println(primeArray[n-1]);
		}
		
	}
	public static void fillPrimeArray() {
		primeArray[0]= 2;
		primeArray[1]= 3; 
		long limit = 10000;
		int j = 5;
		int index = 2;
		while (primeArray[10000]==0) {
			if (checkPrime(j, 2)) {
				primeArray[index] = j;
				index++;
			}
			j+=2;
		}
	}	
	static boolean checkPrime(long n, long i) {
		if (n <= 2)
			return (n == 2) ? true : false;
		if (n % i == 0)
			return false;
		if (i * i > n) {
			return true;
		}
		return checkPrime(n, i + 1);
	}
}
