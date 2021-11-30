package hiring.test.stringreduction;

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
	 * Complete the 'getMinDeletions' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts STRING s
	 * as parameter.
	 */

	public static int getMinDeletions(String s) {
		// Write your code here

		Map<Character, Integer> hm = new HashMap<>();
		int mindeletions = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer val = hm.get(c);
			if (val == null) {
				hm.put(c, 1);
			} else {
				mindeletions++;
			}

		}

		return mindeletions;

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = bufferedReader.readLine();

		int result = Result.getMinDeletions(s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
