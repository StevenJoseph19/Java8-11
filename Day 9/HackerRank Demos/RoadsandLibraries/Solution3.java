package day9.RoadsandLibraries;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Graph {
	int[][] matrix;
	boolean directed;

	Graph(int numberVertices, boolean directed) {
		matrix = new int[numberVertices][numberVertices];
		this.directed = directed;
	}

	public void addEdge(int v1, int v2) {
		matrix[v1][v2] = 1;

		if (!directed)
			matrix[v2][v1] = 1;
	}

	public ArrayList<Integer> getAdjacentVertices(int v) {
		ArrayList<Integer> adjacentVertices = new ArrayList<Integer>();

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[v][i] > 0)
				adjacentVertices.add(i);
		}

		return adjacentVertices;
	}
}

class Result3 {
	static Graph createCitiesGraph(int n, int[][] cities) {
		Graph citiesGraph = new Graph(n, false);

		for (int i = 0; i < cities.length; i++) {
			citiesGraph.addEdge(cities[i][0], cities[i][1]);
		}

		return citiesGraph;
	}

	static long roadsAndLibraries(int n, long c_lib, long c_road, List<List<Integer>> cities) {

		int[][] arrays = cities.stream() // Stream<List<Integer>>
				.map(list -> list.stream().mapToInt(i -> i).toArray()) // Stream<int[]>
				.toArray(int[][]::new);
		if (c_road >= c_lib)
			return n * c_lib;

		Graph citiesGraph = createCitiesGraph(n + 1, arrays);

		int[] visited = new int[n + 1];
		Queue<Integer> vQueue = new LinkedList<Integer>();
		long treesCounter = 0;
		long verticesCounter = 0;

		long treesCounter2 = 0;
		long verticesCounter2 = 0;

		for (int i = 1; i < visited.length; i++) {
			if (visited[i] == 0) {
				vQueue.add(i);
				visited[i] = 1;
				treesCounter++;
				verticesCounter++;
				treesCounter2 += c_lib;
			}

			while (vQueue.size() > 0) {
				int vertice = vQueue.poll();
				ArrayList<Integer> adjVertices = citiesGraph.getAdjacentVertices(vertice);

				for (int j = 0; j < adjVertices.size(); j++) {
					int adjVertice = adjVertices.get(j);

					if (visited[adjVertice] == 1)
						continue;

					verticesCounter++;
					verticesCounter2 += c_road;
					visited[adjVertice] = 1;
					vQueue.add(adjVertice);

				}
			}
		}

		return (verticesCounter - treesCounter) * c_road + (c_lib * treesCounter);
	}
}

public class Solution3 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, q).forEach(qItr -> {
			try {
				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

				int n = Integer.parseInt(firstMultipleInput[0]);

				int m = Integer.parseInt(firstMultipleInput[1]);

				int c_lib = Integer.parseInt(firstMultipleInput[2]);

				int c_road = Integer.parseInt(firstMultipleInput[3]);

				List<List<Integer>> cities = new ArrayList<>();

				IntStream.range(0, m).forEach(i -> {
					try {
						cities.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
								.map(Integer::parseInt).collect(toList()));
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				});

				long result = Result3.roadsAndLibraries(n, c_lib, c_road, cities);

				bufferedWriter.write(String.valueOf(result));
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
