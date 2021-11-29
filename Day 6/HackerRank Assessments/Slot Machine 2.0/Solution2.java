package day6.SlotMachine2;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

class Result2 {

	/*
	 * Complete the 'slotWheels' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * STRING_ARRAY history as parameter.
	 */

	public static int slotWheels(List<String> history) {
		// Write your code here
		int size = history.get(0).length();

		List<BigInteger> list = new ArrayList<BigInteger>();
		for (String string : history) {
			list.add(new BigInteger(string));

		}

		int totalStops = 0;

		BigInteger[] arr = new BigInteger[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = BigInteger.ZERO;
		}

		for (int j = 0; j < list.size(); j++) {

			List<BigInteger> numbers = new ArrayList<>();
			for (BigInteger i = list.get(j); i.compareTo(BigInteger.ZERO) > 0; i = i.divide(new BigInteger("10"))) {
				numbers.add(i.mod(new BigInteger("10")));

			}
			Collections.sort(numbers, Comparator.reverseOrder());

			for (int i = 0; i < numbers.size(); i++) {

				if ((numbers.get(i)).compareTo(arr[i]) == 1) {
					arr[i] = numbers.get(i);

				}

			}
		}

		totalStops = Arrays.asList(arr).stream().reduce(BigInteger::add).orElse(BigInteger.ZERO).intValue();

		return totalStops;
	}
}

public class Solution2 {
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

		int result = Result2.slotWheels(history);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
