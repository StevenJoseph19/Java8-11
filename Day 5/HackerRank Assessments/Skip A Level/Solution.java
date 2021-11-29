package day5.skipalevel;

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
	 * Complete the 'maximumPoints' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER k 2. INTEGER_ARRAY costs
	 */

	public static int maximumPoints(int k, List<Integer> costs) {
		// Write your code here
		int[] arr = costs.stream().mapToInt(i -> i).toArray();

		int currentbal = k;
		boolean flag = false;
		int max = 0;

		for (int i = 0; i < costs.size(); i++) {
			currentbal = currentbal - arr[i];
			System.out.println("currentbal.." + currentbal);

			if (currentbal < 0 && flag) {
				return max;

			}

			if (currentbal < 0 && !flag) {
				currentbal = currentbal + arr[i];
				flag = true;
				continue;

			}

			if (currentbal == 0 && !flag) {
				if (currentbal + arr[i] - arr[i + 1] > 0) {
					currentbal = currentbal + arr[i];
					flag = true;
					continue;
				}
			}
			max++;
		}

		return max;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int k = Integer.parseInt(bufferedReader.readLine().trim());

		int costsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> costs = IntStream.range(0, costsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int result = Result.maximumPoints(k, costs);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
