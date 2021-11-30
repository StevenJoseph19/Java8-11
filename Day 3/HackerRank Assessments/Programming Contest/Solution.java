package hiring.test.programmingcontest;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Result {

	/*
	 * Complete the 'minimizeBias' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY ratings as parameter.
	 */

	public static int minimizeBias(List<Integer> ratings) {
		// Write your code here

		int[] arr = ratings.stream().mapToInt(i -> i).toArray();
		List<Integer> diffs = new ArrayList<>();
		int minBias = 0;
		int i = 1;

		Arrays.sort(arr);

		while (i < arr.length) {

			int diff = arr[i] - arr[i - 1];
			diffs.add(diff);
			i += 2;
		}
		Collections.sort(diffs);

//		System.out.println("Difference in ratings are : " + diffs.toString());

		int numpairs = arr.length / 2;

		for (int j = 0; j < numpairs; j++) {
			minBias += diffs.get(j);

		}
		return minBias;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int ratingsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ratings = IntStream.range(0, ratingsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int result = Result.minimizeBias(ratings);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
