package entities;

public class Employee {

	private Integer ID;
	private String name;
	private Double salary;

	public Employee() {
	}

	public Employee(Integer ID, String name, Double salary) {
		this.ID = ID;
		this.name = name;
		this.salary = salary;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void increaseSalary(double percentage) {
		this.salary = getSalary() + getSalary() * (percentage / 100.00);
	}

	@Override
	public String toString() {
		return getID() + ", " + getName() + ", " + String.format("%.2f", getSalary());
	}

}
