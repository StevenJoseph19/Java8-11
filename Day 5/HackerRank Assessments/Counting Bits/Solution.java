package day5.countingbits;

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
	 * Complete the 'getOneBits' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER n as parameter.
	 */

	public static List<Integer> getOneBits(int n) {

		String string = Integer.toBinaryString(n);

		System.out.println(string);

		int[] ints = Stream.of(string.split("")).mapToInt(Integer::parseInt).toArray();

		List<Integer> list = new ArrayList<>(ints.length);
		int numones = 0;

		for (int i = 0; i < ints.length; i++) {
			if (ints[i] == 1) {
				list.add(i + 1);
				numones++;
			}

		}

		list.add(0, numones);

		return list;

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> result = Result.getOneBits(n);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}