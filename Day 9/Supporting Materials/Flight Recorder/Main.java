import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		System.out.println("Hit any key to start running the code");
		String sc = new Scanner(System.in).nextLine();
		Random randomIntegers = new Random();
		int array[] = new int[Integer.parseInt(args[0])];
		if (args[1].equals("random")) {
			for (int i = 0; i < array.length; i++) {
				array[i] = randomIntegers.nextInt(array.length);
			}
			Arrays.sort(array);
		}
//sorts array in increasing order  
		if (args[1].equals("sorted")) {
			for (int i = 0; i < array.length; i++) {
				array[i] = i;
			}
			Arrays.sort(array);
		}
		System.out.println("Hit any key to end the application.");
		sc = new Scanner(System.in).nextLine();
	}
}