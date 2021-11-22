package com.java8.parallel_stream;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExample {

	public static void main(String[] args) {
		long start = 0;
		long end = 0;

		start = System.currentTimeMillis();
		IntStream.range(1, 100).forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Sequential stream took : " + (end - start) + " milliseconds");

		System.out.println("============================================");

		start = System.currentTimeMillis();
		IntStream.range(1, 100).parallel().forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Parallel stream took : " + (end - start) + " milliseconds");

		IntStream.range(1, 10).forEach(x -> {
			System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x);
		});

		IntStream.range(1, 10).parallel().forEach(x -> {
			System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x);
		});

		List<Employee> employees = EmployeeDatabase.getEmployees();

		// normal
		start = System.currentTimeMillis();
		double salaryWithStream = employees.stream().map(Employee::getSalary).mapToDouble(i -> i).average()
				.getAsDouble();
		end = System.currentTimeMillis();

		System.out.println("Normal stream execution time : " + (end - start) + " milliseconds" + " : Avg salary : "
				+ salaryWithStream);

		start = System.currentTimeMillis();
		double salaryWithParallelStream = employees.parallelStream().map(Employee::getSalary).mapToDouble(i -> i)
				.average().getAsDouble();

		end = System.currentTimeMillis();

		System.out.println("Parallel stream execution time : " + (end - start) + " milliseconds" + " : Avg salary : "
				+ salaryWithParallelStream);
	}
}
