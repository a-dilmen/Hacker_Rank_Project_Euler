package com.dilmen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpecialPythagoreanTriplet {
	static Map<Integer, Long> sumWithTriplets = new HashMap<>();

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int m = -1;
			for (int a = 3; a < (n / 3) + 1; a++) {
				int b = (n * n - 2 * a * n) / (2 * n - 2 * a);
				//int b = -a*a/(a-n);
				int c = n - b - a;
				if (a * a + b * b == c * c) {
					if (a * b * c > m) {
						m = a * b * c;
					}
				}
			}
			System.out.println(m);
		}
		scanner.close();
	}
}

//calculatePytaghorean();

//if (sumWithTriplets.containsKey(n)) {
//System.out.println(sumWithTriplets.get(n));
//} else {
//System.out.println(-1);
//}

//static void calculatePytaghorean() {
////	for (int i = 1; i < 1000; i++) {
////		for (int j = 0; j+i < 1000; j++) {
////			for (int j2 = 0; j+j2 < 1000; j2++) {
////				int a = i;
////				int b = a+j;
////				int c = 1000-j2;
////				if (a<b&&b<c&& a*a+b*b == c*c) {
////					if (sumWithTriplets.containsKey((int) a + b + c)) {
////						for (int j3 = 1; j3 < 333; j3++) {
////							if (sumWithTriplets.get((int) a + b + c) * j3 < (int) a * b * c * j3 * j3 * j3)
////								sumWithTriplets.replace(((int) a + b + c) * j3, (long) a * b * c * j3 * j3 * j3);
////						}
////					} else {
////						for (int j3 = 1; j3 < 751; j3++) {
////							sumWithTriplets.put(((int) a + b + c) * j3, (long) a * b * c * j3 * j3 * j3);
////						}
////					}
////				}
////			}
////		}
////		
////	}
//	int n = 12;
//	int m = 0;
//	for (int a = 3; a < (n / 3) + 1; a++) {
//		int b = (n * n - 2 * a * n) / (2 * n - 2 * a);
//		int c = n - b - a;
//		if (a * a + b * b == c * c) {
//			if (a * b * c > m) {
//				m = a * b * c;
//			}
//		}
//	}
//	//System.out.println(m);
//
//}