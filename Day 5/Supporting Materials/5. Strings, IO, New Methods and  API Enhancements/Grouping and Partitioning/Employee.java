package groupingandpartitioning;

public class Employee {

	private String name;
	private String city;
	private double sales;

	public Employee(String name, String city, double sales) {
		super();
		this.name = name;
		this.city = city;
		this.sales = sales;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", sales=" + sales + "]";
	}

}
