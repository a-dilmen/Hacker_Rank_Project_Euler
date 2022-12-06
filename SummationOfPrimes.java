package com.dilmen;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class SummationOfPrimes {
	// Angle of attack
	// Fill a prime list up to the limit quickly with recursion once to reuse every time its called
	// Sum the values in the primes list below entered number  
	static List<Long> primes = new ArrayList<>();
	public static void main(String[] args) {
		fillPrimeList();
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			sumOfPrimes(n);
		}
		scanner.close();
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
	public static void fillPrimeList() {
		Set<Long> primeList = new LinkedHashSet<>();
		primeList.add(2L);
		long limit = 1000000;
		long j = 2;
		while (j < limit + 1) {
			if (checkPrime(j, 2)) {
				primeList.add(j);
			}
			j++;
		}
		primes = primeList.stream().collect(Collectors.toList());
	}
	public static void sumOfPrimes(int number) {
		long l = primes.stream().filter(num-> num<=number).collect(Collectors.summingLong(Long::longValue)); 
		System.out.println(l);
	}
}