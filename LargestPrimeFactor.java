package ProjectEuler;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LargestPrimeFactor {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				long n = Long.parseLong(bufferedReader.readLine().trim());

				System.out.println(biggestPrimeDivisor(n));

			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}

	public static boolean longIsPrime(long num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static long biggestPrimeDivisor(long num) {
		long bPD = 1;
		for (long i = (long) num; i > 1; i--) {
			if (longIsPrime(i) && num % i == 0) {
				bPD = i;
				return bPD;
			}
		}
		return bPD;

	}

}
