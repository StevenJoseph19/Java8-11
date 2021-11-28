package day6.SlotMachine2;

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
	 * Complete the 'slotWheels' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * STRING_ARRAY history as parameter.
	 */

	public static int slotWheels(List<String> history) {
		// Write your code here

		int size = history.get(0).length();

		List<Long> list = history.stream().map(Long::parseLong).collect(Collectors.toList());

		int totalStops = 0;

		long[] arr = new long[size];

		for (int j = 0; j < list.size(); j++) {

			List<Long> numbers = new ArrayList<>();

			for (long i = list.get(j); i > 0; i /= 10) {
				numbers.add(i % 10);

			}

			Collections.sort(numbers, Comparator.reverseOrder());

			for (int i = 0; i < numbers.size(); i++) {

				if (numbers.get(i) > arr[i]) {
					arr[i] = numbers.get(i);

				}

			}

		}

		totalStops = (int) Arrays.stream(arr).sum();

		return totalStops;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int historyCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> history = IntStream.range(0, historyCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		int result = Result.slotWheels(history);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
