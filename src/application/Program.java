package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> listEmployee = new ArrayList<>();
		
		// PART 1 - READING DATA:

		System.out.print("How many employees will be registered? ");
		int numberOfEmployees = sc.nextInt();
		System.out.println();

		for (int i = 0; i < numberOfEmployees; i++) {

			System.out.println("Emplyoee #" + (i + 1) + ": ");

			System.out.print("Id: ");
			int ID = sc.nextInt();

			while (checkID(ID, listEmployee) == true) {

				System.out.println();
				System.out.print("ID already exists!Try again: ");
				ID = sc.nextInt();

			}

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Salary: ");
			double salary = sc.nextDouble();

			listEmployee.add(new Employee(ID, name, salary));

			System.out.println();
		}

		// PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE:

		System.out.print("Enter the employee id that will have salary increase : ");
		int employeeID = sc.nextInt();

		Integer pos = positionID(employeeID, listEmployee);

		if (pos == null) {
			System.out.println("This id does not exist!");
		}

		else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			listEmployee.get(pos).increaseSalary(percent);

		}
		
		// PART 3 - LISTING EMPLOYEES:

		System.out.println();
		System.out.println("List of employees:");

		for (Employee emp : listEmployee) {
			System.out.println(emp);
		}

		sc.close();
	}

	private static Integer positionID(int employeeID, List<Employee> employee) {

		for (int i = 0; i < employee.size(); i++) {

			if (employee.get(i).getID() == employeeID) 
				return i;
		}
		
		return null;
	}

	private static boolean checkID(int ID, List<Employee> employee) {

		for (int i = 0; i < employee.size(); i++) {

			if (employee.get(i).getID() == ID)
				return true;
		}

		return false;
	}

}
