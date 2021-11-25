package day1.minstartvalue;

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

class Result {

	/*
	 * Complete the 'minX' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY arr as parameter.
	 */

	public static int minX(List<Integer> arr) {
		// Write your code here

		int[] nums = arr.stream().mapToInt(i -> i).toArray();

		int startValue = 0; // Integer.Min_VALUE

		for (int x = startValue; x <= Integer.MAX_VALUE; x++) {

			int sum = x;

			for (int n : nums) {
				sum += n;
				if (sum < 1) {
					break;
				}

			}
			if (sum >= 1) {
				return x;
			}

		}
		return 0;

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int result = Result.minX(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
