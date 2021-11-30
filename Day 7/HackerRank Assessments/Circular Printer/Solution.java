package hiring.test.CircularPrinter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Result {

	/*
	 * Complete the 'getTime' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * STRING s as parameter.
	 */

	public static long getTime(String s) {
		// Write your code here

		s = s.toLowerCase();

		int time = (int) s.charAt(0) - 97;
		if (time > 13)
			time = 26 - time;

		for (int i = 1; i < s.length(); i++) {
			char current = s.charAt(i);
			char previous = s.charAt(i - 1);

			int d = Math.abs(current - previous);

			if (d > 13) {
				d = 26 - d;
			}

			time += d;

		}

		return time;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = bufferedReader.readLine();

		long result = Result.getTime(s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}