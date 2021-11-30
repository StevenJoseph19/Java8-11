package hiring.test.ConferenceSchedule;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

class EndTimeComparator implements Comparator<meet> {
	@Override
	// Sorting meetings based on finish timings
	public int compare(meet o1, meet o2) {
		if (o1.end < o2.end)
			return -1;

		else if (o1.end > o2.end)
			return 1;

		return 0;
	}
}

class meet {
	int start;
	int end;
	int pos;

	// Constructor to create meeting(start,end,position) pairs
	meet(int start, int end) {
		this.start = start;
		this.end = end;

	}

	@Override
	public String toString() {
		return "meet [start=" + start + ", end=" + end + "]";
	}

}

class Result {

	/*
	 * Complete the 'maxPresentations' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY scheduleStart 2. INTEGER_ARRAY scheduleEnd
	 */

	public static int maxPresentations(List<Integer> scheduleStart, List<Integer> scheduleEnd) {
		// Write your code here

		// Defining an arraylist of meet type
		List<meet> pairs = new ArrayList<>();

		for (int i = 0; i < scheduleStart.size(); i++) {
			// Creating pairs of meeting(start,end) and appending to a arraylist
			pairs.add(new meet(scheduleStart.get(i), scheduleEnd.get(i)));
		}

//		List<Integer> m = new ArrayList<>();
		int max = 1;
		EndTimeComparator etc = new EndTimeComparator();

		// Sort meeting according to their end time.
		Collections.sort(pairs, etc);
		System.out.println(pairs);

		// First meeting is always selected

		int prev_end = pairs.get(0).end;

		// Checking if meetings can take place or not.
		for (int i = 1; i < pairs.size(); i++) {
			if (pairs.get(i).start >= prev_end) {

				prev_end = pairs.get(i).end;
				max++;
			}
		}

		return max;

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int scheduleStartCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> scheduleStart = IntStream.range(0, scheduleStartCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int scheduleEndCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> scheduleEnd = IntStream.range(0, scheduleEndCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int result = Result.maxPresentations(scheduleStart, scheduleEnd);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
