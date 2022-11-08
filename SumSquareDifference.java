package ProjectEuler;

import java.io.*;
import java.util.stream.*;

public class SumSquareDifference {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());
				sumSquareDifference(n);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}

	public static long sumOfSquares(long number) {
		long sumOfSquares = (number * (number + 1) * (2 * number + 1)) / 6;
		return sumOfSquares;
	}

	public static long squareOfSum(long number) {
		long sum = (number * (number + 1)) / 2;
		long squareOfSum = sum * sum;
		return squareOfSum;
	}

	public static void sumSquareDifference(int number) {
		long result = squareOfSum(number) - sumOfSquares(number);
		System.out.printf("%1d%n", result);
	}
//	public static void sumSquareDifference(int number) {
//        long result = ((1l*number * (number + 1)) / 2)*((1l*number * (number + 1)) / 2) - ((1l*number * (number + 1) * (2 * number + 1)) / 6);
//        System.out.printf("%1d%n",result);
//    }
}
