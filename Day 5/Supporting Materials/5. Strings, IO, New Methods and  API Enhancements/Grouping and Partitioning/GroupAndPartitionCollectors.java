package groupingandpartitioning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAndPartitionCollectors {

	private static List<Employee> employees = new ArrayList<>();
	static {
		employees.add(new Employee("Alice", "London", 200));
		employees.add(new Employee("Bob", "London", 150));
		employees.add(new Employee("Charles", "New York", 160));
		employees.add(new Employee("Dorothy  ", "Hong Kong", 190));

	}

	public static void main(String[] args) {
		Map<String, List<Employee>> result = new HashMap<>();
		for (Employee e : employees) {
			String city = e.getCity();
			List<Employee> empsInCity = result.get(city);
			if (empsInCity == null) {
				empsInCity = new ArrayList<>();
				result.put(city, empsInCity);
			}
			empsInCity.add(e);
		}

		System.out.println(result);

		System.out.println("Employees in the company:");
		employees.stream().forEach(employee -> System.out.println(employee));

		System.out.println("Group by city:");
		Map<String, List<Employee>> cityMap = employees.stream().collect(Collectors.groupingBy(Employee::getCity));
		cityMap.forEach((key, value) -> {
			System.out.println(key);
			value.forEach(System.out::println);
		});

		System.out.println("Partition by Good Sales (less than or equal to $160) or Great Sales (greater than $150) :");
		Map<Boolean, List<Employee>> priceMap = employees.stream()
				.collect(Collectors.partitioningBy(musicalInstrument -> musicalInstrument.getSales() > 150));
		priceMap.forEach((key, value) -> {
			System.out.println((key ? "Great Sales " : "Good Sales"));
			value.forEach(System.out::println);
		});
	}

}
