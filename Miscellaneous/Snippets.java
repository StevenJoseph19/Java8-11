import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

public class Snippets {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3);
		int[] arr = list.stream().mapToInt(i -> i).toArray();
		
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int toc = list.stream().reduce(0, Integer::sum);
	}

}
