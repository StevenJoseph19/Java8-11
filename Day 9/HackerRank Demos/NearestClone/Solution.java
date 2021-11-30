package day9.NearestClone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	// Complete the findShortest function below.

	/*
	 * For the unweighted graph, <name>:
	 *
	 * 1. The number of nodes is <name>Nodes. 2. The number of edges is <name>Edges.
	 * 3. An edge exists between <name>From[i] to <name>To[i].
	 *
	 */
	static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
		// solve here
		LinkedList<Integer>[] map = new LinkedList[graphNodes];
		HashMap<Integer, Integer> distances = new HashMap();

		for (int i = 0; i < graphNodes; i++) {
			map[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < graphFrom.length; i++) {
			map[graphFrom[i] - 1].add(graphTo[i]);
			map[graphTo[i] - 1].add(graphFrom[i]);
		}

		Queue<Integer> queue = new LinkedList();
		for (int i = 0; i < ids.length; i++) {
			if (ids[i] == val) {
				queue.add(i + 1);
				distances.put(i + 1, 0);
			}
		}

		if (queue.size() < 2) {
			return -1;
		}
		HashSet<Integer> seen = new HashSet();
		while (queue.size() > 0) {
			int current = queue.poll();
			seen.add(current);

			for (int a : map[current - 1]) {
				if (distances.containsKey(a) && !seen.contains(a)) {
					return distances.get(a) + distances.get(current) + 1;
				} else {
					queue.add(a);
					distances.put(a, distances.get(current) + 1);
				}
			}
		}
		return -1;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] graphNodesEdges = scanner.nextLine().split(" ");
		int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
		int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

		int[] graphFrom = new int[graphEdges];
		int[] graphTo = new int[graphEdges];

		for (int i = 0; i < graphEdges; i++) {
			String[] graphFromTo = scanner.nextLine().split(" ");
			graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
			graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
		}

		long[] ids = new long[graphNodes];

		String[] idsItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < graphNodes; i++) {
			long idsItem = Long.parseLong(idsItems[i]);
			ids[i] = idsItem;
		}

		int val = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

		bufferedWriter.write(String.valueOf(ans));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
