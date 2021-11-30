package day8.Queues;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static class MyQueue<T> {
		Stack<T> stackSecond = new Stack<T>();
		Stack<T> stackFirst = new Stack<T>();

		public void enqueue(T value) { // Push onto newest stack
			stackSecond.push(value);
		}

		public T peek() {
			transferStack();
			return stackFirst.peek();
		}

		public T dequeue() {
			transferStack();
			return stackFirst.pop();
		}

		private void transferStack() {
			if (!stackFirst.isEmpty())
				return;
			while (!stackSecond.isEmpty()) {
				stackFirst.push(stackSecond.pop());
			}
		}
	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}
}
