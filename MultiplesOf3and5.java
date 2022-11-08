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

public class MultiplesOf3and5 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());
				sumUpto(n);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

		});

		bufferedReader.close();
	}

	public static void sumUpto(int number) {
		long sum = 0;
		long ref3 = (number - 1) / 3;
		long ref5 = (number - 1) / 5;
		long ref15 = (number - 1) / 15;
		long rref3 = (ref3 * (ref3 + 1)) / 2;
		long rref5 = (ref5 * (ref5 + 1)) / 2;
		long rref15 = (ref15 * (ref15 + 1)) / 2;
		sum = rref3 * 3 + rref5 * 5 - rref15 * 15;

		System.out.println(sum);
	}

}
