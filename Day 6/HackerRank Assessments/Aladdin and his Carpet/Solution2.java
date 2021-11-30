package hiring.test.AladdinandhisCarpet;

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

class Result2 {

	/*
	 * Complete the 'optimalPoint' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY magic 2. INTEGER_ARRAY dist
	 */

	public static int optimalPoint(List<Integer> magic, List<Integer> dist) {
		// Write your code here

		int[] magicarr = magic.stream().mapToInt(i -> i).toArray();
		int[] distarr = dist.stream().mapToInt(i -> i).toArray();

		// First, handle unsuccessful journey
		if (Arrays.stream(magicarr).sum() < Arrays.stream(distarr).sum()) {
			return -1;
		}

		int totalValue = 0;
		int startIndex = 0;
		int length = magicarr.length;

		for (int i = 0; i < length; i++) {
			if (totalValue < 0) {
				startIndex = i;
				totalValue = 0;
			}

			totalValue += (magicarr[i] - distarr[i]);
		}
		return startIndex;
	}

}

public class Solution2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int magicCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> magic = IntStream.range(0, magicCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int distCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> dist = IntStream.range(0, distCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int result = Result.optimalPoint(magic, dist);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
